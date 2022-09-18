package ua.com.foxminded.formulaone;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Formula1DataLoader formula1Data = new Formula1DataLoader("FilesLog/start.log", "FilesLog/end.log",
                "FilesLog/abbreviations.txt");

        Formula1ReportGeneration report = new Formula1ReportGeneration();
        System.out.println(report.generateReport(formula1Data));

    }

}
