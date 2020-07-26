package com.sy.hrsys3;

import bean.Jhunter;
import bean.OperaResult;
import service.Service;

/**
 * @author sy
 * @date 2020/7/26 21:28
 */
public class Driver {

    static Service service = new Service();

    public OperaResult add(Jhunter jhunter) {
        return service.add(jhunter);
    }

    public OperaResult delete(String name) {
        Service service = new Service();
        return service.delete(name);
    }

    public OperaResult update(Jhunter jhunter) {
        Service service = new Service();
        return service.update(jhunter);
    }

    public OperaResult searchByName(String name) {
        Service service = new Service();
        return service.searchByName(name);
    }
}


