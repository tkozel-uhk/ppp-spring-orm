package cz.uhk.ppro.studiis;

import cz.uhk.ppro.studiis.model.Predmet;
import cz.uhk.ppro.studiis.model.Student;
import cz.uhk.ppro.studiis.model.StudijniProgram;
import cz.uhk.ppro.studiis.model.Ucitel;
import cz.uhk.ppro.studiis.repos.PredmetRepository;
import cz.uhk.ppro.studiis.repos.StudentRepository;
import cz.uhk.ppro.studiis.repos.StudijniProgramRepository;
import cz.uhk.ppro.studiis.repos.UcitelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hlavní třída aplikace - demonstrace práce s JPA
 * @see CommandLineRunner
 */
@SpringBootApplication
@Transactional //bez tohoto se neuloží některé (cascade) změny do databáze, nedrží se session pro dočítání LAZY vztahů
public class StudijniIsApplication implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UcitelRepository ucitelRepository;

    @Autowired
    private StudijniProgramRepository studijniProgramRepository;
    @Autowired
    private PredmetRepository predmetRepository;


    public static void main(String[] args) {
        SpringApplication.run(StudijniIsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student student = new Student();
        student.setJmeno("Jan");
        student.setPrijmeni("Novak");
        //student = studentRepository.save(student);

        Ucitel ucitel = new Ucitel();
        ucitel.setJmeno("Petr");
        ucitel.setPrijmeni("Svoboda");
        //ucitel = ucitelRepository.save(ucitel);

        Predmet predmet1 = new Predmet();
        predmet1.setZkratka("ZMI1");
        predmet1.setNazev("Základy matematiky I");
        predmet1.setPocetHodinPrednasky(3);
        predmet1.setPocetHodinCviceni(2);
        predmet1.setGarant(ucitel);
        //predmet1 = predmetRepository.save(predmet1);

        Predmet predmet2 = new Predmet();
        predmet2.setZkratka("PRO1");
        predmet2.setNazev("Programování I");
        predmet2.setPocetHodinPrednasky(4);
        predmet2.setPocetHodinCviceni(1);
        predmet2.setGarant(ucitel);
        //predmet2 = predmetRepository.save(predmet2);

        StudijniProgram program1 = new StudijniProgram();
        program1.setNazev("Aplikovaná informatika");
        program1.setTyp("bc");
        program1.setDelka(3);

        StudijniProgram program2 = new StudijniProgram();
        program2.setNazev("Infomrační management");
        program2.setTyp("ing");
        program2.setDelka(2);

        student.getPredmety().add(predmet1);
        student.getPredmety().add(predmet2);
        student.getStudijniProgramy().add(program1);
        student.getStudijniProgramy().add(program2);

        program1.getStudenti().add(student);
        program2.getStudenti().add(student);

        ucitel.getGarantovanePredmety().add(predmet1);
        ucitel.getGarantovanePredmety().add(predmet2);

        studijniProgramRepository.save(program1);
        studijniProgramRepository.save(program2);
        ucitelRepository.save(ucitel);
        studentRepository.save(student);

        //vypíšeme všechny programy a studenty z databáze
        predmetRepository.findAll().forEach(System.out::println);
        studentRepository.findAll().forEach(System.out::println);

        //zkusime nějakou interakci s daty v DB a něco přidat/aktualizovat
        StudijniProgram nactenyProgram = studijniProgramRepository.findByNazev("Aplikovaná informatika");
        Student novyStudent = new Student("Josef", "Vomáčka");
        nactenyProgram.getStudenti().add(novyStudent);
        novyStudent.getStudijniProgramy().add(nactenyProgram);
        studentRepository.save(novyStudent);
        studijniProgramRepository.save(nactenyProgram);
        System.out.println(nactenyProgram.getNazev());
        nactenyProgram.getStudenti().forEach(System.out::println);
    }
}
