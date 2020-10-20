package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import vn.codegym.model.Role;
import vn.codegym.model.UserEmployee;
import vn.codegym.repository.UserEmployeeRepository;
import vn.codegym.service.UserEmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserEmployeeServiceImpl implements UserEmployeeService, UserDetailsService {
    @Autowired
    UserEmployeeRepository userEmployeeRepository;

    @Override
    public Iterable<UserEmployee> findAll() {
        return userEmployeeRepository.findAll();
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEmployee account = userEmployeeRepository.findByUserName(username);
        if (account == null) {
            throw  new UsernameNotFoundException("Account not found: "+username);
        }
        Set<Role> roleSetList = account.getRoles();
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        for (Role role : roleSetList) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleName());
            grantedAuthorityList.add(grantedAuthority);
        }
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(account.getUserName(), account.getPassword(), grantedAuthorityList);
        return userDetails;
    }
}
