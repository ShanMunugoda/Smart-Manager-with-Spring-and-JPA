/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.business.custom.Impl;

import lk.ijse.comp.business.custom.AllocateStatusBO;
import lk.ijse.comp.dao.custom.AllocateStatusDAO;
import lk.ijse.comp.dao.custom.BranchDAO;
import lk.ijse.comp.dao.custom.ProjectDAO;
import lk.ijse.comp.dto.AllocateStatusDTO;
import lk.ijse.comp.dto.BranchDTO;
import lk.ijse.comp.dto.ProjectDTO;
import lk.ijse.comp.entity.AllocateStatus;
import lk.ijse.comp.entity.AllocateStatus_PK;
import lk.ijse.comp.entity.Branch;
import lk.ijse.comp.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SDMROX
 */

@Component
@Transactional
public class AllocateStatusBOImpl implements AllocateStatusBO {
    @Autowired
    private AllocateStatusDAO allocatestatusDAO;
    @Autowired
    private BranchDAO branchDAO;
    @Autowired
    private ProjectDAO projectDAO;
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public AllocateStatusBOImpl() {

    }


    @Override
    public boolean saveAllocstestatus(AllocateStatusDTO allocateStatus) throws Exception {

        AllocateStatus allocatestatus = new AllocateStatus(allocateStatus.getEid(), allocateStatus.getPid(), allocateStatus.getStatus(), allocateStatus.getDateleft());
        allocatestatusDAO.Save(allocatestatus);
        return true;

    }

    @Override
    public boolean updateAllocatestatus(AllocateStatusDTO allocateStatus) throws Exception {

        AllocateStatus allocateStatus1 = allocatestatusDAO.findById(new AllocateStatus_PK(allocateStatus.getEid(), allocateStatus.getPid()));
        allocateStatus1.setStatus(allocateStatus.getStatus());
        allocateStatus1.setDateleft(allocateStatus.getDateleft());
        System.out.println(allocateStatus.getStatus());

//            AllocateStatus allocatestatus = new AllocateStatus(allocateStatus.getEid(), allocateStatus.getPid(), allocateStatus.getStatus(), allocateStatus.getDateleft());
        allocatestatusDAO.Update(allocateStatus1);
        return true;

    }

    @Override
    public boolean deleteAllocatestatus(String eid, String pid) throws Exception {
        AllocateStatus_PK x = new AllocateStatus_PK(eid, pid);
        allocatestatusDAO.Delete(x);

        return true;

    }

    @Override
    public ArrayList<AllocateStatusDTO> allAllocatestatus() throws Exception {

        ArrayList<AllocateStatusDTO> arr = new ArrayList<>();
        List<AllocateStatus> all = allocatestatusDAO.getAll();

        System.out.println("AlL : " + all.toString());

        for (AllocateStatus allocateStatus : all) {
            AllocateStatusDTO allocateStatusDTO = new AllocateStatusDTO(allocateStatus.getAlloctedStatus_pk().getEid(), allocateStatus.getAlloctedStatus_pk().getPid(), allocateStatus.getStatus(), allocateStatus.getDateleft());
            arr.add(allocateStatusDTO);

        }
        return arr;


    }

    @Override
    public AllocateStatusDTO findById(String eid, String pid) throws Exception {

        AllocateStatus_PK x = new AllocateStatus_PK(eid, pid);
        AllocateStatus find = allocatestatusDAO.findById(x);
        AllocateStatusDTO allocateStatusDTO = new AllocateStatusDTO(find.getAlloctedStatus_pk().getEid(), find.getAlloctedStatus_pk().getPid(), find.getStatus(), find.getDateleft());

        return allocateStatusDTO;

    }

    @Override
    public ArrayList<BranchDTO> allBids() throws Exception {

        List<Branch> all = branchDAO.getAll();
        ArrayList<BranchDTO> arr = new ArrayList<>();
        for (Branch branch : all) {
            BranchDTO branchDTO = new BranchDTO(branch.getBid());
            arr.add(branchDTO);
        }
        return arr;

    }

    @Override
    public ArrayList<AllocateStatusDTO> allPids() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<AllocateStatusDTO> allEids() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProjectDTO> allPids_and_Bids() throws Exception {

        List<Project> all = projectDAO.getAll();
        ArrayList<ProjectDTO> arr = new ArrayList<>();

        for (Project prj : all) {
            ProjectDTO projectDTO = new ProjectDTO(prj.getPid(), prj.getBranch().getBid());
            arr.add(projectDTO);

        }

        return arr;

    }


}
