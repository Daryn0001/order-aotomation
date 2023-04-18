package kz.sdu.stu.dsalimov.impl;

import kz.sdu.stu.dsalimov.dao.EventDao;
import kz.sdu.stu.dsalimov.dao.PlaceDao;
import kz.sdu.stu.dsalimov.dto.db.Event;
import kz.sdu.stu.dsalimov.dto.db.Place;
import kz.sdu.stu.dsalimov.dto.to_client.MainPageBody;
import kz.sdu.stu.dsalimov.dto.to_client.MainPageHeader;
import kz.sdu.stu.dsalimov.dto.to_client.Slide;
import kz.sdu.stu.dsalimov.dto.to_client.SlideItem;
import kz.sdu.stu.dsalimov.register.MainPageRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainPageRegisterImpl implements MainPageRegister {
    @Autowired
    private PlaceDao placeDao;

    @Autowired
    private EventDao eventDao;

    @Override
    public MainPageHeader getHeader() {
        return new MainPageHeader("27", "Moscow", "Company");
    }

    @Override
    public MainPageBody getBody() {
        List<Event> eventList = this.eventDao.findAll();
        List<Place> placeList = this.placeDao.findAll();

        System.out.println("EventList: " + eventList);
        System.out.println("PlaceList: " + placeList);

        var slideItemList = new ArrayList<SlideItem>();

        eventList.forEach(x -> {
            ;
            slideItemList.add(new SlideItem(x.getTitle(), x.getImage()));
        });

        var p0 = placeList.get(0);
        var p1 = placeList.get(1);
        var featured = new Slide(p0.getType(), p0.getSize(), slideItemList);
        var hot = new Slide(p1.getType(), p1.getSize(), slideItemList);

        var data = new MainPageBody();
        data.addSlides("featured", featured);
        data.addSlides("hot", hot);
        return data;
    }
}
