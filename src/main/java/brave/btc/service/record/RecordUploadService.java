package brave.btc.service.record;

import org.springframework.web.multipart.MultipartFile;

import brave.btc.dto.record.DiaryDto;

public interface RecordUploadService {

	/**
	 * 사진을 업로드한다.
	 * @param multipartFile 업로드할 사진 파일.
	 * @param objectKey 저장되는 이름
	 * @param encodePassword 암호화 비밀번호.
	 * @return 업로드된 주소
	 */
	String uploadPicture(MultipartFile multipartFile, String objectKey, String encodePassword);

	/**
	 * 일기를  업로드한다.
	 * @param diaryDto Diary dto
     * @param objectKey 저장되는 이름
	 * @param encodePassword 암호화 비밀번호
	 * @return 업로드된 주소
	 */
	String uploadDiary(DiaryDto diaryDto, String objectKey, String encodePassword);
}