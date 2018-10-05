/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.dao.custom.Impl;

import lk.ijse.comp.dao.CrudDAOImpl;
import lk.ijse.comp.dao.custom.EmployeeDAO;
import lk.ijse.comp.entity.Employee;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

/**
 *
 * @author SDMROX
 */
@Component
public class EmployeeDAOImpl extends CrudDAOImpl<Employee,String> implements EmployeeDAO {


}
