package user;

import generated.ErsteBankStatements;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class KivonatMarshaller {

    public void marshal() {
        Long start = System.currentTimeMillis();
//        JAXBContext context = null;
//        try {
//            context = JAXBContext.newInstance(ErsteBankStatements.class);
//            Marshaller mar=  context.createMarshaller();
//            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//            mar.marshal(book, new File("./book.xml"));
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
        File xmlFile = new File("src/main/resources/ANONIM_STTD_20200101_001ZIR_MA_1D9M_3_EBE_F_P (1).XML");
        File realXmlFile = new File("C:\\Users\\machine\\Documents\\ERSTE\\KSR\\real.xml");
        File outPutXmlFile = new File("C:/Temp/output.xml");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ErsteBankStatements.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Marshaller marshaller = jaxbContext.createMarshaller();
            ErsteBankStatements ersteBankStatements = (ErsteBankStatements) jaxbUnmarshaller.unmarshal(realXmlFile);
            System.out.println(ersteBankStatements.getStatement().size());
            List<ErsteBankStatements.Statement> statements = ersteBankStatements.getStatement();
            ErsteBankStatements.Statement statement0 = statements.get(0);
            ErsteBankStatements.Statement statement1 = statements.get(1);
            for (int i = 0; i <2500 ; i++) {
                statements.add(statement0);
                statements.add(statement1);
            }

            marshaller.marshal(ersteBankStatements,outPutXmlFile);
            System.out.println(ersteBankStatements.getSetting().getBANKNAME());
            System.out.println(ersteBankStatements.getStatement().get(0).getAccount().getAccountName());
            Long stop = System.currentTimeMillis();
            Long elapsedTime = stop - start;
            System.out.println("Elapsed Time: " + elapsedTime);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
