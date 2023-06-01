package brave.btc.controller.bo;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import brave.btc.dto.CommonResponseDto;
import brave.btc.dto.bo.BackOfficeManagePerson.ManagePersonInfoDto;
import brave.btc.dto.bo.BackOfficeManagePerson.ManagePersonRegisterListDto;
import brave.btc.dto.bo.OfficialInstitutionDto;
import brave.btc.dto.common.auth.register.RegisterDto;
import brave.btc.exception.ErrorResponseDto;
import brave.btc.service.bo.BackOfficeManagePersonService;
import brave.btc.service.bo.OfficialInstitutionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "21. BO_Back Office Manage Person", description = "백오피스 Admin 관련 API")
@Slf4j
@Valid
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/bo-manage-persons")
public class BackOfficeManagePersonController {

    private final BackOfficeManagePersonService backOfficeManagePersonService;
    private final OfficialInstitutionService officialInstitutionService;

    @Operation(summary = "회원 가입 요청 목록 조회", description = "요청한 회원 가입 목록을 가져온다",
            responses = {
                    @ApiResponse(responseCode = "200", description = "회원 가입 요청 리스트 조회 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array=@ArraySchema(schema = @Schema(implementation = RegisterDto.ManagePersonResponse.class)))),
                    @ApiResponse(responseCode = "400", description = "회원 가입 요청 리스트 조회 실패",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorResponseDto.class)))
            })
    @GetMapping("/permission")
    public ResponseEntity<?> findManagePersonRegisterList() {
        List<ManagePersonRegisterListDto> managePersonRegisterList = backOfficeManagePersonService.findManagePersonRegisterList();
        CommonResponseDto<Object> responseDto = CommonResponseDto.builder().data(managePersonRegisterList).build();
        return ResponseEntity.ok()
                .body(responseDto);
    }

    @Operation(summary = "회원 가입 요청 승인", description = "회원 가입 요청을 승인한다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "회원 가입 요청 승인 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array=@ArraySchema(schema = @Schema(implementation = CommonResponseDto.class)))),
                    @ApiResponse(responseCode = "400", description = "회원 가입 요청 승인 실패",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorResponseDto.class)))
            })
    @PutMapping("/permission/{managePersonId}")
    public ResponseEntity<?> permissionManagerPersonRegister(@PathVariable Integer managePersonId) {
        backOfficeManagePersonService.permissionManagerPersonRegister(managePersonId);
        CommonResponseDto<Object> responseDto = CommonResponseDto.builder().build();
        return ResponseEntity.ok()
                .body(responseDto);
    }

    @Operation(summary = "관리 개인 정보 조회", description = "관리 개인 정보를 조회한다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "정보 조회 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array=@ArraySchema(schema = @Schema(implementation = CommonResponseDto.class)))),
                    @ApiResponse(responseCode = "400", description = "정보 조회 실패",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorResponseDto.class)))
            })
    @GetMapping("/info/{managePersonId}")
    public ResponseEntity<?> findManagePersonInfo(@PathVariable Integer managePersonId) {
        ManagePersonInfoDto managePersonInfo = backOfficeManagePersonService.findManagePersonInfo(managePersonId);
        CommonResponseDto<Object> responseDto = CommonResponseDto.builder().data(managePersonInfo).build();
        return ResponseEntity.ok()
                .body(responseDto);
    }

    @Operation(summary = "공식 기관 추가", description = "공식 기관을 등록한다. 공식 기관은 bo manage person만 등록 가능함.",
        responses = {
            @ApiResponse(responseCode = "200", description = "공식 기관 등록 성공",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = CommonResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "유효성 검사 통과 실패",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponseDto.class)))
        })
    @PostMapping
    public ResponseEntity<?> createOfficialInstitution(
        @RequestBody OfficialInstitutionDto.Create requestDto
    ) {

        String message = officialInstitutionService.createOfficialInstitution(requestDto);
        CommonResponseDto<Object> responseDto = CommonResponseDto.builder().data(message).build();

        return ResponseEntity.ok()
            .body(responseDto);
    }


}