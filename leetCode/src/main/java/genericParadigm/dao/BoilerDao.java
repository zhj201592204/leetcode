package genericParadigm.dao;

import genericParadigm.dao.impl.IBaseDao;
import genericParadigm.data.Boiler;

public class BoilerDao implements IBaseDao<Boiler> {


    @Override
    public void add() {
        System.out.println("add boiler");
    }

    @Override
    public void del() {
        System.out.println("del boiler");
    }

    @Override
    public void update() {

    }

    @Override
    public void query() {

    }
}
