/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.dao.custom.Impl;

import lk.ijse.comp.dao.CrudDAOImpl;
import lk.ijse.comp.dao.custom.ProjectDAO;
import lk.ijse.comp.entity.Project;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

/**
 *
 * @author SDMROX
 */
@Component
public class ProjectDAOImpl extends CrudDAOImpl<Project,String> implements ProjectDAO {


}
