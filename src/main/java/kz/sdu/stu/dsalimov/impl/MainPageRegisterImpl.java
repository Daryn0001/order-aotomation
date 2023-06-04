package kz.sdu.stu.dsalimov.impl;

import kz.sdu.stu.dsalimov.dao.BranchDao;
import kz.sdu.stu.dsalimov.dao.EventDao;
import kz.sdu.stu.dsalimov.dao.PlaceDao;
import kz.sdu.stu.dsalimov.dao.TableDao;
import kz.sdu.stu.dsalimov.dto.db.Branch;
import kz.sdu.stu.dsalimov.dto.db.Place;
import kz.sdu.stu.dsalimov.dto.db.Table;
import kz.sdu.stu.dsalimov.dto.to_client.MainPageBody;
import kz.sdu.stu.dsalimov.dto.to_client.MainPageHeader;
import kz.sdu.stu.dsalimov.dto.to_client.Slide;
import kz.sdu.stu.dsalimov.dto.to_client.SlideItem;
import kz.sdu.stu.dsalimov.register.MainPageRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MainPageRegisterImpl implements MainPageRegister {
    @Autowired
    private PlaceDao placeDao;

    @Autowired
    private EventDao eventDao;

    @Autowired
    private TableDao tableDao;

    @Autowired
    private BranchDao branchDao;

    @Override
    public MainPageHeader getHeader(String temporaryKey) {
        var table = this.tableDao.findByTempKey(temporaryKey);

        Branch branch = null;
        if (!ObjectUtils.isEmpty(table)) {
            branch = this.branchDao.findByUuid(table.getBranchUuid());
        } else {
            throw new RuntimeException("Could not find table by temporary key: " + temporaryKey);
        }

        if (!ObjectUtils.isEmpty(branch)) {
            return new MainPageHeader(table.getInternalId(), branch.getAddress(), branch.getName());
        } else {
            throw new RuntimeException("Could not find branch by id: " + table.getBranchUuid());
        }
    }

    @Override
    public MainPageBody getBody(String temporaryKey) {
        List<Place> placeList;
        var data = new MainPageBody();

        try {
            Table table = this.tableDao.findByTempKey(temporaryKey);
            if (Objects.isNull(table)) {
                throw new RuntimeException("Could not find table by temporary key: " + temporaryKey);
            }

            Branch branch = this.branchDao.findByUuid(table.getBranchUuid());

            if (Objects.isNull(branch)) {
                throw new RuntimeException("Could not find branch by id: " + table.getBranchUuid());
            }

            placeList = this.placeDao.findByBranchUuid(branch.getUuid());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        placeList.forEach(place -> {
            String placeName = place.getName().trim().replace(' ', '_');
            var list = this.eventDao.findByPlaceUuid(place.getUuid());

            var slideItemList = new ArrayList<SlideItem>(
                    list.stream()
                            .map(event -> new SlideItem(
                                    event.getUuid(),
                                    event.getTitle(),
                                    event.getImage(),
                                    event.getPlaceUuid())
                            ).toList());

            data.addSlides(placeName, new Slide(place.getName(), place.getType(), place.getSize(), slideItemList));
        });

        return data;
    }
}
