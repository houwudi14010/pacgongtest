

package com.test.service;

        import com.test.pojo.Test;

        import java.util.List;

public interface TestService {
    int addPaper(Test paper);

    int deletePaperById(long id);

    int updatePaper(Test paper);

    Test queryById(long id);

    List<Test> queryAllPaper();
}
