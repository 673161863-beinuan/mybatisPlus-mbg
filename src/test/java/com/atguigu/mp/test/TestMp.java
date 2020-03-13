package com.atguigu.mp.test;

import com.baomidou.mybatisplus.annotations.DataSource;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

public class TestMp {

    @Test
    public void testMp(){

        //1.全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true) //设置是否开启AR模式
            .setAuthor("beinuan")  //设置作者名
            .setIdType(IdType.AUTO) //设置主键生成策略
            .setBaseResultMap(true) //设置是否生成xml映射文件
            .setOutputDir("D:\\ct-project\\mybatis-plus02\\src\\main\\java") //生成代码的路径
            .setFileOverride(true)  //多次生成是否覆盖
            .setServiceName("%sService") //
            .setBaseColumnList(true); //生成SQL片段

        //2.数据源配置
        DataSourceConfig dbConfig = new DataSourceConfig();
        dbConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/mp")
                .setUsername("root")
                .setPassword("123456");

        //3.策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true) //全局大写命名
                .setDbColumnUnderline(true)  //指定数据库表是否使用下滑线
                .setNaming(NamingStrategy.underline_to_camel) //下划线转驼峰命名
                .setTablePrefix("tbl")  //表名前缀
                .setInclude("tbl_employee"); //指定要生成的表明

        //4包名生成策略
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.atguigu.mp")
                .setEntity("beans")
                .setMapper("mapper")
                .setXml("mapper")
                .setService("service")
                .setServiceImpl("service.impl")
                .setController("controller");

        //5.整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config)
                .setDataSource(dbConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);

        //6.执行生成
        autoGenerator.execute();
    }
}
