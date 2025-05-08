public class dosen {
    gradeReport grade = new gradeReport();
    public void inputNilai(mahasiswa mhs, double tugas, double kuis, double uts, double uas) {
        mhs.getGrade().setNilai(tugas, kuis, uts, uas);
        // grade.setNilai(tugas, kuis, uts, uas);
    }
}
