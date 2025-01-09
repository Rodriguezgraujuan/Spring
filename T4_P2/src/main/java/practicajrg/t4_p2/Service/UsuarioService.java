package practicajrg.t4_p2.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import practicajrg.t4_p2.Entities.Usuario;
import practicajrg.t4_p2.Repository.UsuarioRepository;

import java.util.Arrays;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByUsername(username);
        if (usuario.isPresent()) {
            Usuario miUsuario=usuario.get();
            return Usuario.builder()
                    .name(miUsuario.getName())
                    .password(miUsuario.getPassword())
                    .roles(Arrays.toString(miUsuario.getRoles().split(",")))
                    .build();
        }else {
            throw new UsernameNotFoundException(username);
        }
    }
}
