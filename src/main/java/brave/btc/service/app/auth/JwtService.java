package brave.btc.service.app.auth;

import brave.btc.dto.common.auth.jwt.JwtResponseDto;

public interface JwtService {

    /**
     * Refresh Token을 생성하거나 갱신한다.
     * @param refreshToken 생성하거나 갱신할 refreshToken
     * @param userId refreshToken과 매칭되는 userId
     */
    void updateRefreshToken(String refreshToken, Integer userId);

    /**
     * Access Token이 만료되었을 경우 Refresh Token의 유효성을 검사하고,
     * Access Token과 Refresh Token을 갱신한다.
     * @param refreshToken 유효성을 검증할 refreshToken
     * @return 갱신된 Access Token과 Refresh Token
     */
    JwtResponseDto refresh(String refreshToken);
}