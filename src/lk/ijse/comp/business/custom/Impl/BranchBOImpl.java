/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.business.custom.Impl;

import lk.ijse.comp.business.custom.BranchBO;
import lk.ijse.comp.dao.custom.BranchDAO;
import lk.ijse.comp.dto.BranchDTO;
import lk.ijse.comp.entity.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SDMROX
 */
@Component
@Transactional
public class BranchBOImpl implements BranchBO {
    @Autowired
    private BranchDAO branchDAO;
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    public BranchBOImpl() {
        

    }
    
    

    @Override
    public boolean saveBranch(BranchDTO dto) throws Exception {
        Branch brnh=new Branch(dto.getBid(), dto.getBname(), dto.getBaddress());

            branchDAO.Save(brnh);

       return true;
        
    }

    @Override
    public boolean updateBranch(BranchDTO dto) throws Exception {

            Branch brnh = new Branch(dto.getBid(), dto.getBname(), dto.getBaddress());

            branchDAO.Update(brnh);

        return true;
    }

    @Override
    public boolean deleteBranch(String id) throws Exception {


            branchDAO.Delete(id);

        return true;
    }

    @Override
    public ArrayList<BranchDTO> allBranch() throws Exception {

            ArrayList<BranchDTO> arr = new ArrayList<>();
            List<Branch> allbranch = branchDAO.getAll();

            for (Branch branch : allbranch) {

                BranchDTO brnh = new BranchDTO(branch.getBid(), branch.getBname(), branch.getBaddress());
                arr.add(brnh);

            }

            return arr;

    }

    @Override
    public BranchDTO findById(String bid) throws Exception {


            Branch find = branchDAO.findById(bid);
            BranchDTO brnhdto = new BranchDTO(find.getBid(), find.getBname(), find.getBaddress());

            return brnhdto;

    }
  
}
