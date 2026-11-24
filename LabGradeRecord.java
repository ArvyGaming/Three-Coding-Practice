/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labgraderecord;

/**
 *
 * @author DAHIROC_CPE113
 */
public class LabGradeRecord {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LabGrade ana = new LabGrade("Ana", 80, 90);
        LabGrade ben = new LabGrade("Ben", 101, 85);

        System.out.println("Ana's starting grade: "
                + ana.getFinalGrade());
        System.out.println("Ana is passing: "
                + ana.isPassing());

        System.out.println("Ben's starting grade: "
                + ben.getFinalGrade());
        System.out.println("Ben is passing: "
                + ben.isPassing());

        System.out.println("Ana updates scores to 95 and 101: "
                + ana.updateScores(95, 101));
        System.out.println("Ana's grade: "
                + ana.getFinalGrade());

        System.out.println("Ana updates scores to 74 and 75: "
                + ana.updateScores(74, 75));
        System.out.println("Ana's grade: "
                + ana.getFinalGrade());
        System.out.println("Ana is passing: "
                + ana.isPassing());

        System.out.println("Ana updates scores to 75 and 75: "
                + ana.updateScores(75, 75));
        System.out.println("Ana's grade: "
                + ana.getFinalGrade());
        System.out.println("Ana is passing: "
                + ana.isPassing());

        System.out.println("Ben's final grade: "
                + ben.getFinalGrade());
        System.out.println("Ben is passing: "
                + ben.isPassing()); 
    }   
    }
     class LabGrade {

    private String studentName;
    private int quizScore;
    private int labScore;

    public LabGrade(String studentName, int quizScore, int labScore) {
        this.studentName = studentName;

        if (quizScore < 0 || quizScore > 100) {
            this.quizScore = 0;
        } else {
            this.quizScore = quizScore;
        }

        if (labScore < 0 || labScore > 100) {
            this.labScore = 0;
        } else {
            this.labScore = labScore;
        }
    }

    public boolean updateScores(int quizScore, int labScore) {
        if (quizScore < 0 || quizScore > 100 ||
            labScore < 0 || labScore > 100) {
            return false;
        }

        this.quizScore = quizScore;
        this.labScore = labScore;
        return true;
    }

    public double getFinalGrade() {
        return (this.quizScore * 0.40) + (this.labScore * 0.60);
    }

    public boolean isPassing() {
        return getFinalGrade() >= 75.0;

    }
}

// Activity 2 Q1.
// Why must you validate both new scores before assigning either one? 
// Both scores must be validated before assigning either one 
// to prevent partial updates. If one score is invalid, both 
// original scores must remain unchanged. This ensures that 
// the student's grade record stays accurate and consistent.
