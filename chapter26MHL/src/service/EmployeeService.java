package service;

import dao.EmployeeDAO;
import domain.Employee;

public class EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    /**
     * 根据 empId 和 pwd 返回 员工对象
     *
     * @param empId 员工id
     * @param pwd   密码
     * @return 返回 Employee 对象,如果查不到返回 null
     */
    public Employee getEmployeeByIdAndPwd(String empId, String pwd) {
        return employeeDAO.querySingle("select * from employee where empId = ? and pwd = md5(?)", Employee.class, empId, pwd);
    }
}
