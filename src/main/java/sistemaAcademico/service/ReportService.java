package sistemaAcademico.service;

import sistemaAcademico.model.User;
import sistemaAcademico.repository.UserRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private UserRepository repository;

    public  String exportReport(String reportFormat) {
        List<User> Users = repository.findAll();

        try {
            File file = ResourceUtils.getFile("C:\\Users\\Leonardo\\Documents\\Programação\\sistema-academico\\src\\main\\resources\\Users.jrxml");

            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource dataResource = new JRBeanCollectionDataSource(Users);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("createdBy", "Java Techie");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataResource);

            if (reportFormat.equalsIgnoreCase("pdf")){
                JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\Leonardo\\Documents\\Usuarios.pdf");
            }
            if (reportFormat.equalsIgnoreCase("html")){
                JasperExportManager.exportReportToHtmlFile(jasperPrint, "C:\\Users\\Leonardo\\Documents\\Usuarios.html");
            }

            return "Relatorio Gerado!";
        }catch(Exception e){
            System.out.println(e.toString());
            return "";
        }

    }

}
