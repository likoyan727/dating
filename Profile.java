// Liana Ikoyan
// 002395362
// ikoyan@chapman.edu
// CPSC-231-01
// MP1_DatingApp
// This file simulates a dating app and the functions of liking and matching profiles

//class Profile
public class Profile {

  //m_name, Name of the profile
  private String m_name;
  //m_age, Age of the profile
  private int m_age;
  //m_swipesRight, array of likes from other profiles
  private String[] m_swipesRight = new String[10];
  //m_matches, array of matches with another profile
  private String[] m_matches = new String[10];


  //Default constructor Profile
  public Profile() {
    m_name = "";
    m_age = 0;
    m_swipesRight = m_swipesRight;
    m_matches = m_matches;
  }

  //Overloaded constructor Profile
  // Parameters: String name, int age
  public Profile(String name, int age) {
    m_name = name;
    m_age = age;
    m_swipesRight = m_swipesRight;
    m_matches = m_matches;
  }
  //getName, accessor of member m_name
  // returns String m_name
  public String getName() {
    return m_name;
  }
  //setName, mutator of member m_name
  // Parameter: String name
  public void setName(String name) {
    m_name = name;
  }

  //getName, accessor of member m_age
  // returns integer m_age
  public int getAge() {
    return m_age;
  }
  //setName, mutator of member m_age
  // Parameter: int age
  public void setAge(int age) {
    m_age = age;
  }

  //getName, accessor of member m_swipesRight
  // returns String array m_swipesRight
  public String[] getSwipesRight() {
    return m_swipesRight;
  }
  //setName, mutator of member m_swipesRight
  // Parameter: String swipeRight, int index
  public void setSwipesRight(String swipeRight, int index) {
    m_swipesRight[index] = swipeRight;
  }

  //getName, accessor of member m_matches
  // returns String array m_matches
  public String[] getMatches() {
    return m_matches;
  }
  //setName, mutator of member m_matches
  // Parameter: String match, int index
  public void setMatches(String match, int index) {
    m_matches[index] = match;
  }

  //method toString
  // returns String that describes the profile with age and name
  public String toString() {
    return "Name: " + m_name + "\nAge: " + m_age;
  }

  //method equals, determines whether two profiles are equal
  // Parameter: Profile profile, takes in the profile to compare
  // Returns boolean value for whether two profiles are equal or not
  public boolean equals(Profile profile) {
    Profile otherProfile = (Profile) profile;
    return this.m_name.equals(otherProfile.m_name);
  }

  //method swipeRight, adds current profile's name to other profile's like array,
  //adds both names to match arrays, or informs user that max matches or likes have been reached
  // Paremeter: Profile profile2, the other profile
  public void swipeRight(Profile profile2) {
    Profile otherProfile = (Profile) profile2;

    for (int i=0; i < 10; ++i){
      if (otherProfile.getName().equals(m_swipesRight[i])) {
        for (int n=0; n < 10; ++n){
          if (otherProfile.getMatches()[n] != null) {
            continue;
          }
          else if (otherProfile.getMatches()[n] == null){
            for (int k=0; k < 10; ++k){
              if (m_matches[k] != null){
                  continue;
              }
              else if (m_matches[k] == null){
                otherProfile.setMatches(m_name, n);
                m_matches[k] = otherProfile.getName();
                break;
              }
              else {
                System.out.println("Max amount of matches reached.");
              }
            }
          }
          break;
          }
        }
      else {
        if (otherProfile.getSwipesRight()[i] != null) {
          continue;
          }
        else if (otherProfile.getSwipesRight()[i] == null){
          otherProfile.setSwipesRight(m_name, i);
          break;
          }
        else {
          System.out.println("Max amount of likes reached.");
          }
        }
      }
    }
  //method swipeLeft, removes other profile's name from current profile's like array
  // Paremeter: Profile profile2, the other profile
  public void swipeLeft(Profile profile2) {
    Profile otherProfile = (Profile) profile2;
    for (int i=0; i < 10; ++i){
      if (m_swipesRight[i] == null){
        continue;
      }
      else {
        if (m_swipesRight[i].equals(otherProfile.getName())){
          m_swipesRight[i] = null;
        }
      }
    }
  }

  //main method
  public static void main(String[] args){
    Profile person1 = new Profile("Will Smith", 53);
    Profile person2 = new Profile("Jada Smith", 50);

    person1.swipeRight(person2);
    person2.swipeRight(person1);

    for (String p : person1.getMatches()){
      System.out.println(p);
    }
    for (String p : person2.getMatches()){
      System.out.println(p);
    }

  }
}
