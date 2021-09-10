package com.liftoff.welcome;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "111111";
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println(rawPassword);
        System.out.println(encodedPassword);
    }

}



//      $2a$10$F47xK.tCXMYVoJ57fsi0n.VzoUZOmgf7pgbboAbDDjP.ds3X4mKAK    lululu  from reg backend_sprint4
//      $2a$10$JxprpIELTnBYRqowdc7p9eMHavRIGK9.I0MveRiIq3Ey/KdTERVNe             test generated


//      $2a$10$09yMzf3dKykARucnE9E0L.1wcqA03WDElD9IIWx7G1kzLdbBeFf5W  lanceboy   reg, not verified
//      $2a$10$09yMzf3dKykARucnE9E0L.1wcqA03WDElD9IIWx7G1kzLdbBeFf5W             after verification

//      $2a$10$CKYZxw7Vb.5/ndls9bsnOufwS3HGzOCR6obizAg1O/RSCaA/jSYX6             test generated
//      $2a$10$kyUu.aimwuVotvQhpCfOo.8twx/VjzTtCUv5iQOKAgmfMzw4VA9QW             test generated

//      $2a$10$cUAnrOzO.2rhG1RqLS5MMedZWws3NOIuqu6uOWDrLehNRv8UVVF0i    111111   reg generated -FAIL
//      $2a$10$CeGY6utEQpZE4bLPxX5oouUQoYT.l3TY60X/vcyUE3FSF3bv1k81u             test generation
