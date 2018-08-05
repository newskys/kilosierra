package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LoginApiController {
//    @Autowired
//    MemberService memberService;
//
//    @PostMapping(value = "/login/register")
//    ResponseEntity register(String username, String password, String email) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//        Member member = new Member();
//        member.setPassword(passwordEncoder.encode(password));
//        member.setEmail(email);
//        member.setRoleType(RoleType.ROLE_ADMIN.getRoleType());
//        member.setUserId(username);
//
//        try {
//            memberService.createMember(member);
//        } catch (Exception e) {
//            log.error("{}", e, e);
//            new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }


//    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
//    public void loginPage(ModelAndView mav) {
//
//    }
//
//    @Autowired
//    AuthenticationManager authenticationManager;
//    @Autowired
//    SecurityContextRepository repository;
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    @ResponseBody
//    public ModelMap login(HttpServletRequest request, HttpServletResponse response,
//                          @RequestParam(value = "id") String username,
//                          @RequestParam(value = "password") String password) {
//
//        ModelMap map = new ModelMap();
//
//        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
//                username, password);
//
//        try {
//            // 로그인
//            Authentication auth = authenticationManager.authenticate(token);
//            SecurityContextHolder.getContext().setAuthentication(auth);
//            repository.saveContext(SecurityContextHolder.getContext(), request, response);
//
//            map.put("success", true);
//            map.put("returnUrl", getReturnUrl(request, response));
//        } catch (BadCredentialsException e) {
//            map.put("success", false);
//            map.put("message", e.getMessage());
//        }
//
//        return map;
//    }
//
//    /**
//     * 로그인 하기 전의 요청했던 URL을 알아낸다.
//     *
//     * @param request
//     * @param response
//     * @return
//     */
//    private String getReturnUrl(HttpServletRequest request, HttpServletResponse response) {
//        RequestCache requestCache = new HttpSessionRequestCache();
//        SavedRequest savedRequest = requestCache.getRequest(request, response);
//        if (savedRequest == null) {
//            return request.getSession().getServletContext().getContextPath();
//        }
//        return savedRequest.getRedirectUrl();
//    }
}
