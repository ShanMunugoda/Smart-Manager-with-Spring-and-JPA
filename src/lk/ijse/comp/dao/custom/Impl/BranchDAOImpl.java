/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.dao.custom.Impl;

import lk.ijse.comp.dao.CrudDAOImpl;
import lk.ijse.comp.dao.custom.BranchDAO;
import lk.ijse.comp.entity.Branch;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

/**
 *
 * @author SDMROX
 */
@Component
public class BranchDAOImpl extends CrudDAOImpl<Branch,String> implements BranchDAO {


}
