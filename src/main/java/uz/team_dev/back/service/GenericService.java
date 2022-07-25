package uz.team_dev.back.service;

import uz.team_dev.back.vo.VO;
import uz.team_dev.back.vo.response.Data;
import uz.team_dev.back.vo.response.Response;

import java.io.Serializable;
import java.util.List;

public interface GenericService<
        D extends VO,
        CVO extends VO,
        UVO extends VO,
        ID extends Serializable
        > {


    Response<Data<ID>> persist(CVO dto);
    Response<Data<Boolean>> delete(ID id);
    Response<Data<Boolean>> update(UVO dto);
    Response<Data<D>> find(ID id);
    Response<Data<D>> find(String name);
    Response<Data<List<D>>> findAll();

}
