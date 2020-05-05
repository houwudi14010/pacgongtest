

package com.test.dao;

        import com.test.pojo.Test;

        import java.util.List;

public interface TestDao {
    int addPaper(Test paper);

    int deletePaperById(long id);

    int updatePaper(Test paper);

    Test queryById(long id);

    List<Test> queryAllPaper();


}