import com.sparta.homework.dto.UserDto;
import com.sparta.homework.model.JwtAuthenticationProvider;
import com.sparta.homework.model.User;
import com.sparta.homework.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

@RequiredArgsConstructor
@Controller
public class UserApi {


    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private JwtAuthenticationProvider jwtAuthenticationProvider;

    @PostMapping("/join")
    public void join(@RequestBody UserDto user){
        userRepository.save(User.builder()
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .name(user.getUsername())
                .roles(Collections.singletonList("ROLE_USER"))
                .build());


    }

    @PostMapping("/login")
    public UserDto login(@RequestBody UserDto user, HttpServletResponse response) {
        User member = userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));
        if (!passwordEncoder.matches(user.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }

        String token = jwtAuthenticationProvider.createToken(member.getUsername(), member.getRoles());
        response.setHeader("X-AUTH-TOKEN", token);

        return new UserDto(member);
    }

    @PostMapping("/logout")
    public void logout(HttpServletResponse response){

    }

    @GetMapping("/info")
    public UserDto getInfo() {
    }

}