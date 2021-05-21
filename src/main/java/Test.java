public abstract class Test {

  private static StringBuilder resu = new StringBuilder();

//  public static void main(String[] args) {
//    List<String> rowIds = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
//    List<String> toBeDeleted = new ArrayList<>(Arrays.asList("2", "4"));
//
//    List<String> sublist = rowIds.subList(1, rowIds.size());
//    sublist.add(rowIds.size() - 1, rowIds.get(0));
//    System.out.println(sublist);
//  }

  /** Gets or Sets SectionType */
  public enum SectionType {
    FORMSECTION("FormSection"),

    SUPPLIERSECTION("SupplierSection"),

    TEAMSECTION("TeamSection"),

    TODOSECTION("TodoSection"),

    FIELDSSECTION("FieldsSection"),

    FINDINGSSECTION("FindingsSection"),

    VERBATIMSSECTION("VerbatimsSection"),

    SUPPLIERASSESSMENTSECTION("SupplierAssessmentSection"),

    PROJECTASSESSMENTSECTION("ProjectAssessmentSection"),

    KNOWLEDGECHECKSECTION("KnowledgeCheckSection"),

    FUNDINGSECTION("FundingSection"),

    ACTUALSSECTION("ActualsSection"),

    LIBRARYSECTION("LibrarySection"),

    TABLESECTION("TableSection"),

    NESTEDPROJECTSSECTION("NestedProjectsSection"),

    ANALYSISPROJECTSECTION("AnalysisProjectSection");

    private String value;

    SectionType(String value) {
      this.value = value;
    }


    public String toString() {
      return String.valueOf(value);
    }


    public static SectionType fromValue(String text) {
      for (SectionType b : SectionType.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  static class ABC {
   private SectionType sectionType;


    public SectionType getSectionType() {
      return sectionType;
    }

    public void setSectionType(SectionType sectionType) {
      this.sectionType = sectionType;
    }
  }

    public static void main(String[] args) {
//    List<String> lists = Arrays.asList("x", "y", "zff");
//
//    List<String> stuff = lists.stream()
//        .filter( x -> x.length() >=3 )
//        .collect(Collectors.toUnmodifiableList());

    System.out.println(SectionType.valueOf("erer"));
  }


  private static String conv(int no) {
    if (no <= 0) {
      return "0";
    }
    int s = no % 2;
    conv(no / 2);
    return resu.append(s).toString();

  }

  private static boolean canAssign(Class clazz) {
    return Test.class.isAssignableFrom(clazz);
  }


}

enum Time {
  GOODTIME,
  BADTIME;

  public static boolean isValidKey(String key) {
    try {
      return Time.valueOf(key) instanceof Time;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }
}