package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.UserEmployee;

public interface UserEmployeeRepository extends JpaRepository<UserEmployee,String> {
    UserEmployee findByUserName(String accountName);
}
