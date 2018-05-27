package com.example.security;

import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    public CustomLoginSuccessHandler(String defaultTargetUrl) {
        setDefaultTargetUrl(defaultTargetUrl);
    }

    // 로그인 성공 후 직전 페이지로 돌아가기
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//                                        Authentication authentication) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        if (session != null) {
//            String redirectUrl = (String) session.getAttribute("prevPage");
//            if (redirectUrl != null) {
//                session.removeAttribute("prevPage");
//                getRedirectStrategy().sendRedirect(request, response, redirectUrl);
//            } else {
//                super.onAuthenticationSuccess(request, response, authentication);
//            }
//        } else {
//            super.onAuthenticationSuccess(request, response, authentication);
//        }
//    }
}
