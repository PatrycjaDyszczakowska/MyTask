package com.credit.app.dao;

import com.credit.app.config.DataSourceConfig;
import com.credit.app.model.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CreditDaoImp extends JdbcDaoSupport implements CreditDao {
    @Autowired
    DataSourceConfig dataSourceConfig;

    @PostConstruct
    private void initialize(){
        dataSourceConfig = new DataSourceConfig();
        setDataSource(dataSourceConfig.getDataSource());
    }

    @Override
    public List<Credit> GetCredit() {
        String sql = "SELECT * FROM task.Credit";
        List<Map<String,Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Credit> result = new ArrayList<>();
        for (Map<String, Object> row:rows){
            Credit credit = new Credit();
            credit.setID((int)row.get("ID"));
            credit.setCreditName((String) row.get("CreditName"));
            result.add(credit);
        }
        System.out.println(result);
        return result;
    }

    @Override
    public void CreateCredit(Credit credit) {

    }
}
