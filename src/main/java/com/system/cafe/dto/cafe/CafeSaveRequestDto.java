package com.system.cafe.dto.cafe;

import com.system.cafe.domain.Amenity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
public class CafeSaveRequestDto {
    private String category;
    private Amenity[] amenities;

    @Size(min = 1, message = "카페 사진을 하나 이상 등록해주세요.")
    private MultipartFile[] multipartFiles;

    @Length(max = 12, message = "카페명은 32자까지 입력할 수 있습니다.")
    @NotBlank(message = "카페명을 입력해주세요.")
    private String cafeName;
    @Size(max = 5, message = "상세 설명은 500자까지 입력할 수 있습니다.")
    private String description;


}
