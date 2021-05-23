package com.sh.admin.ifs;

import com.sh.admin.model.network.Header;

public interface CrudInterface {

    Header create();

    Header read(Long id);

    Header update();

    Header delete(Long id);

}
