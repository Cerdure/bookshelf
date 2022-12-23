package com.cerdure.bookshelf.service;

import com.cerdure.bookshelf.domain.board.Inquire;
import com.cerdure.bookshelf.dto.board.InquireDto;
import com.cerdure.bookshelf.repository.FileRepository;
import com.cerdure.bookshelf.repository.InquireRepository;
import com.cerdure.bookshelf.service.interfaces.InquireService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class InquireServiceImpl implements InquireService {

    private final InquireRepository inquireRepository;
    private final FileRepository fileRepository;
    private final UploadFileServiceImpl uploadFileService;

    @Override
    public Long create(InquireDto inquireDto) {
        Inquire inquire = inquireDto.toEntity();
        inquireRepository.save(inquire);
        return inquire.getId();
    }

    @Override
    public Page<Inquire> findAll(Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1); // page는 index 처럼 0부터 시작
        pageable= PageRequest.of(page,3, Sort.by("regDate").descending());
        return inquireRepository.findAll(pageable);
    }

    @Override
    public Inquire findById(Long inquireId) {
        return inquireRepository.findById(inquireId).get();
    }

    @Override
    public Page<Inquire> findByTitle(String title, Pageable pageable) {
        return inquireRepository.findByTitleContainingIgnoreCase(title, pageable);
    }

    @Override
    public Page<Inquire> findByMemberId(Long memberId, Pageable pageable) {
        return inquireRepository.findByMemberId(memberId, pageable);
    }

    @Override
    public Inquire findPrevInquire(Inquire inquire) {
        LocalDateTime regDate = inquire.getRegDate();
        List<Inquire> findResult = inquireRepository.findByRegDateBefore(regDate);
        if(findResult == null || findResult.size() == 0){
            return Inquire.builder().build();

        } else {
            return findResult.get(0);
        }
    }

    @Override
    public Inquire findNextInquire(Inquire inquire) {
        LocalDateTime regDate = inquire.getRegDate();
        List<Inquire> findResult = inquireRepository.findByRegDateAfter(regDate);
        if(findResult == null || findResult.size() == 0){
            return Inquire.builder().build();

        } else {
            return findResult.get(0);
        }
    }

    @Override
    public void modify(Long inquireId, InquireDto inquireDto, Authentication authentication) throws Exception {
        Inquire inquire = inquireRepository.findById(inquireId).get();
//        System.out.println("inquire.getMember().getPhone() = " + inquire.getMember().getPhone());
//        System.out.println("authentication.getName() = " + authentication.getName());
//        if(inquire.getMember().getPhone() == authentication.getName()){
            inquire.changeTitle(inquireDto.getTitle());
            inquire.changeContent(inquireDto.getContent());
            inquire.changeClosed(inquireDto.getClosed());
            inquire.changePw(inquireDto.getPw());
            inquireRepository.save(inquire);
//        } else {
//            throw new Exception("작성자가 일치하지 않습니다.");
//        }
    }

    @Override
    public void delete(Long inquireId, Authentication authentication) throws Exception {
        Inquire inquire = inquireRepository.findById(inquireId).get();
//        System.out.println("inquire.getMember().getPhone() = " + inquire.getMember().getPhone());
//        System.out.println("authentication.getName() = " + authentication.getName());
//        if(inquire.getMember().getPhone() == authentication.getName()){
            inquireRepository.delete(inquire);
//        } else {
//            throw new Exception("작성자가 일치하지 않습니다.");
//        }
    }
}
