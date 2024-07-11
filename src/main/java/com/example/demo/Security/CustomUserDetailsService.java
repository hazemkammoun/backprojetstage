/*
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.stereotype.Service;
 * 
 * import com.example.demo.entities.Utilisateur; import
 * com.example.demo.service.UtilisateurService;
 * 
 * @Service public class CustomUserDetailsService implements UserDetailsService
 * {
 * 
 * @Autowired private UtilisateurService utilisateurService;
 * 
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException { Utilisateur utilisateur =
 * utilisateurService.findUserByUsername(username); if (utilisateur == null) {
 * throw new
 * UsernameNotFoundException("Utilisateur non trouvé avec le nom d'utilisateur : "
 * + username); } return org.springframework.security.core.userdetails.User
 * .withUsername(utilisateur.getUsername()) .password(utilisateur.getPassword())
 * .roles(utilisateur.getRoles().stream().map(Role::getRole).toArray(String[]::
 * new)) .build(); } }
 */