create or replace function is_valid_json(p_json text)
    returns boolean
as
$$
begin
    return (p_json::json is not null);
exception
    when others then
        return false;
end;
$$
    language plpgsql
    immutable;