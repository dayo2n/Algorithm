package BOJ;

import gitrepourlparser.PersonalGitRepositoryUrlParser;
import readmegenerator.BOJReadmeGenerator;

public class RMGenerator {
    public static void main(String[] args) {
        PersonalGitRepositoryUrlParser parser = new PersonalGitRepositoryUrlParser("dayo2n", "Algorithm", "main");
        BOJReadmeGenerator rg = new BOJReadmeGenerator(parser);

        rg.setTitle("알고리즘 늦깎이 다니의 solved.log");
        rg.generate();
    }
}
