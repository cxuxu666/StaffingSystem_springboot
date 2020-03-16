package cn.zafu.springboot03web.dao;

import cn.zafu.springboot03web.pojo.Department;
import cn.zafu.springboot03web.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//员工Dao
@Repository
public class EmployeeDao {
    //模拟数据
    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer,Employee>();

        employees.put(1001,new Employee(1001,"AA","111@163.com",1,new Department(101,"教育部"),null));
        employees.put(1002,new Employee(1002,"BB","222@163.com",0,new Department(102,"市场部"),null));
        employees.put(1003,new Employee(1003,"CC","333@163.com",0,new Department(103,"教研部"),null));
        employees.put(1004,new Employee(1004,"DD","444@163.com",1,new Department(104,"运营部"),null));
        employees.put(1005,new Employee(1005,"EE","555@163.com",1,new Department(105,"后勤部"),null));


    }

    private static Integer ininid = 1006;
    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(ininid++);
        }
        employee.setDepartment(departmentDao.getDepartments(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }
    public Collection<Employee> getAll(){
        return employees.values();
    }
    public Employee getEmployee (Integer id){
        return employees.get(id);
    }
    public void delect(Integer id){
        employees.remove(id);
    }
}
