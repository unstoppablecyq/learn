package icu.cccccyq;

import icu.cccccyq.mapper.EmpMapper;
import icu.cccccyq.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class CrudMybatisApplicationTests {

    @Autowired
    private EmpMapper empMapper;
    @Test
    public void testDelete() {
        empMapper.delete(17);
//        int delete = empMapper.delete(16);
//        System.out.println(delete);
    }
    @Test
    public void testInsert(){
        Emp emp = new Emp();
        emp.setUsername("user2");
        emp.setName("name2");
        emp.setImage("514.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        empMapper.insert(emp);
        System.out.println(emp.getId());
    }

    @Test
    public void testUpdate(){
        Emp emp = new Emp();
        emp.setId(18);
        emp.setUsername("user3");
        emp.setName("name3");
        emp.setImage("1919.jpg");
        emp.setGender((short) 1);
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        empMapper.update(emp);
    }

    @Test
    public void testFindById() {
        Emp emp = empMapper.getById(19);
        System.out.println(emp);
    }

    @Test
    public void testList(){
//        List<Emp> empList = empMapper.list("张", (short)1, LocalDate.of(2010,1,1), LocalDate.of(2020,1,1));
//        List<Emp> empList = empMapper.list("张", null, null, null);
//          List<Emp> empList = empMapper.list(null, (short)1, null, null);
          List<Emp> empList = empMapper.list(null, null, null, null);
        System.out.println(empList);
    }

    @Test
    public void testUpdate2(){
        Emp emp = new Emp();
        emp.setId(19);
        emp.setUsername("cyq");
        emp.setName("CYQ");
        emp.setGender((short)1);
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.update2(emp);
    }

    @Test
    public void testDeleteByIds(){
        List<Integer> ids = Arrays.asList(13,14,15);
        empMapper.deleteByIds(ids);
    }



    }