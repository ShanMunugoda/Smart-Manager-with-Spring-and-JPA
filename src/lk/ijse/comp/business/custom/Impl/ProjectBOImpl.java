/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.business.custom.Impl;

import lk.ijse.comp.business.custom.ProjectBO;
import lk.ijse.comp.dao.custom.BranchDAO;
import lk.ijse.comp.dao.custom.ProjectDAO;
import lk.ijse.comp.dto.BranchDTO;
import lk.ijse.comp.dto.ProjectDTO;
import lk.ijse.comp.entity.Branch;
import lk.ijse.comp.entity.Project;
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
public class ProjectBOImpl implements ProjectBO {
    @Autowired
    private ProjectDAO projectDAO;
    @Autowired
    private BranchDAO branchDAO;
    @Autowired
    private EntityManagerFactory entityManagerFactory;


    public ProjectBOImpl() {


    }


    @Override
    public boolean saveProject(ProjectDTO dto) throws Exception {

            Project project=new Project(dto.getPid(),dto.getPname(),dto.getStartdate(),dto.getEnddate(),new Branch(dto.getBid()));

         projectDAO.Save(project);

            return true;


    }






    @Override
    public boolean updateProject(ProjectDTO dto) throws Exception {

        return false;
    }

    @Override
    public boolean deleteProject(String id) throws Exception {

           projectDAO.Delete(id);

           return true;


    }

    @Override
    public ArrayList<ProjectDTO> allProject() throws Exception {

            ArrayList<ProjectDTO> arr = new ArrayList<>();

            List<Project> all = projectDAO.getAll();
            for (Project project : all) {
                ProjectDTO projectDTO = new ProjectDTO(project.getPid(), project.getPname(), project.getStartdate(), project.getEnddate(), project.getBranch().getBid());
                arr.add(projectDTO);
            }

            return arr;


    }

    @Override
    public ProjectDTO findById(String pid) throws Exception {

            Project find = projectDAO.findById(pid);
            ProjectDTO projectDTO = new ProjectDTO(find.getPid(), find.getPname(), find.getStartdate(), find.getEnddate(), find.getBranch().getBid());

            return projectDTO;

    }


    @Override
    public ArrayList<BranchDTO> allBids() throws Exception {

            List<Branch> all = branchDAO.getAll();



            ArrayList<BranchDTO> arr = new ArrayList<>();

            for (Branch branch : all) {

                String bid = branch.getBid();
                BranchDTO branchDTO = new BranchDTO(bid);
                arr.add(branchDTO);
            }
            return arr;




    }


   
}
