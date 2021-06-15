package genericParadigm.dao;

import genericParadigm.dao.impl.IBaseDao;
import genericParadigm.data.Container;

public class ContainerDao implements IBaseDao<Container> {


    @Override
    public void add() {
        System.out.println("容器新增");
    }

    @Override
    public void del() {

    }

    @Override
    public void update() {

    }

    @Override
    public void query() {

    }
}
