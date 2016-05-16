import java.util.Scanner;

public class Laddu{

  /** Simple representation of a user. */
  private static class User{
    // Where he is from.
    String origin;

    // Contests won in laddus.
    int rank;

    //  Number of times user has hosted a contest.
    int top;

    // How many bugs he has found.
    int severity;

    // Number of times user has hosted a contest.
    int host;


  }

  public static void main( String[] args ){
    // Scanner to parse input.
    Scanner in = new Scanner( System.in );

    // Read the number of users.
    int n = in.nextInt();
    // List of users.
    User[] userList = new User [ n ];
    for( int i = 0; i < n; i++ ){
      userList[ i ] = new User();
      // Read the number of activities.
      int m = in.nextInt();
      // Read and assign the origin to the current user.
      userList[ i ].origin = in.next();
      for( int j = 0; j < m; j++){
        // Read the first activity.
        String l = in.next();
        if( l.equals("CONTEST_WON") ){
          int rank = in.nextInt();
          userList[ i ].rank += 300;
          if( rank <= 20)
            userList[ i ].rank += 20 - rank;
        }
        else if( l.equals("TOP_CONTRIBUTOR") )
          userList[ i ].top += 1;
        else if( l.equals("BUG_FOUND") )
          userList[ i ].severity += in.nextInt();
        else if( l.equals("CONTEST_HOSTED") )
          userList[ i ].host += 1;
      }
    }

    int laddus = 0;
    // Compute the laddus.
    for ( int i = 0; i < n; i++ ){
      if( userList[ i ].rank != 0 ){
        laddus += userList[ i ].rank;
      }
      if( userList[ i ].top > 0 )
        laddus += 300 * userList[ i ].top;
      if( userList[ i ].severity > 0 )
        laddus += userList[ i ].severity;
      if( userList[ i ].host > 0 )
        laddus += 50 * userList[ i ].host;
      int r = 0;
      if ( userList[ i ].origin.equals("INDIAN"))
        r = laddus/200;
      else if ( userList[ i ].origin.equals("NON_INDIAN"))
        r = laddus/400;
      System.out.println(r);
      laddus = 0;
    }

  }
}
