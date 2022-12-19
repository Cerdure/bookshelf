package com.cerdure.bookshelf;

import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.domain.UploadFile;
import com.cerdure.bookshelf.domain.board.Review;
import com.cerdure.bookshelf.domain.enums.MemberRole;
import com.cerdure.bookshelf.domain.member.Address;
import com.cerdure.bookshelf.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

/**
 * 종 주문 2개
 * * userA
 * 	 * JPA1 BOOK
 * 	 * JPA2 BOOK
 * * userB
 * 	 * SPRING1 BOOK
 * 	 * SPRING2 BOOK
 */
@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInitBooks();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;
        private final BCryptPasswordEncoder passwordEncoder;

        public void dbInitBooks() {
            Book[] books = new Book[93];

            books[0] = Book.builder()
                    .name("철학은 어떻게 삶의 무기가 되는가 (리커버)")
                    .imgPath("/img/book-cover/93.jpg")
                    .category(19)
                    .intro("철학이 현실 세계와 동떨어진 학문이라는 말을 강하게 부정하는 저자는 사람들이 철학을 쓸모없다고 여기는 이유가 철학과 비즈니스를 연결시켜서 생각하는 법을 모르기 때문이라고 진단한다. 오히려 그는 본질을 꿰뚫고 최적의 솔루션을 찾아내는 철학적 사고법이야말로 현대인들에게 가장 필요한 무기라고 말한다. 그가 비즈니스 현장에서 유용하게 사용하는 50가지 철학·사상을 담은 『철학은 어떻게 삶의 무기가 되는가』는 철학의 쓸모를 새롭게 조명하는 세상에서 가장 실용적인 철학 사용 설명서다.\n")
                    .build();

            books[1] = Book.builder()
                    .name("다이어트 사이언스")
                    .imgPath("/img/book-cover/1.jpg")
                    .category(5)
                    .intro("문제는 칼로리가 아니라 지방 세포를 알지 못한 것이다.")
                    .build();

            books[2] = Book.builder()
                    .name("소원빵집 위시위시 베이커리")
                    .imgPath("/img/book-cover/2.jpg")
                    .category(20)
                    .intro("입냄새 물과 악당 컵케이크")
                    .build();

            books[3] = Book.builder()
                    .name("싱크 엑설런트")
                    .imgPath("/img/book-cover/3.jpg")
                    .category(8)
                    .intro("그들은 어떻게 고객의 마음을 훔쳤나?")
                    .build();

            books[4] = Book.builder()
                    .name("이토록 신기한 IT는 처음입니다")
                    .imgPath("/img/book-cover/4.jpg")
                    .category(12)
                    .intro("전공가자 아닌 당신을 위한 퇴근길 디지털 교양 수업")
                    .author("정철환")
                    .build();

            books[5] = Book.builder()
                    .name("이건희 반도체 전쟁")
                    .imgPath("/img/book-cover/5.jpg")
                    .category(7)
                    .intro("반도체가 세계를 지배한다!")
                    .build();

            books[6] = Book.builder()
                    .name("잘될 수밖에 없는 너에게")
                    .imgPath("/img/book-cover/6.jpg")
                    .category(2)
                    .intro("60만 명이 귀 기울이는 응원 에세이")
                    .build();

            books[7] = Book.builder()
                    .name("계산된 삶")
                    .imgPath("/img/book-cover/7.jpg")
                    .category(3)
                    .intro("명령을 따르지 않으면 기억이 리셋된다")
                    .build();

            books[8] = Book.builder()
                    .name("이 책은 돈 버는 법에 관한 이야기")
                    .imgPath("/img/book-cover/8.jpg")
                    .category(7)
                    .intro("서민갑부의 생각법, 독서법, 장사법")
                    .build();

            books[9] = Book.builder()
                    .name("유령들의 패자부활전")
                    .imgPath("/img/book-cover/9.jpg")
                    .category(9)
                    .intro("능력주의, 가장 한국적인 계급 지도")
                    .build();

            books[10] = Book.builder()
                    .name("그건 부당합니다")
                    .imgPath("/img/book-cover/10.jpg")
                    .category(10)
                    .intro("우리가 믿어온 '공정'의 기준이 뒤집어진다")
                    .build();

            books[11] = Book.builder()
                    .name("랑과 나의 사막")
                    .imgPath("/img/book-cover/11.jpg")
                    .category(3)
                    .build();

            books[12] = Book.builder()
                    .name("라이브 인사이드")
                    .imgPath("/img/book-cover/12.jpg")
                    .category(19)
                    .intro("이 수업에는 무언가 특별한 것이 있다")
                    .build();

            books[13] = Book.builder()
                    .name("부자의 서재에는 반드시 심리학 책이 놓여 있다")
                    .imgPath("/img/book-cover/13.jpg")
                    .category(4)
                    .intro("부자는 심리를 읽고 빈자는 심리에 휘둘린다")
                    .build();

            books[14] = Book.builder()
                    .name("책들의 부엌")
                    .imgPath("/img/book-cover/14.jpg")
                    .category(3)
                    .intro("갓 지은 맛있는 밥 냄새가 풀풀 풍기는 여기는 '소량리 북스 치킨'입니다")
                    .build();

            books[15] = Book.builder()
                    .name("불편한 편의점 2")
                    .imgPath("/img/book-cover/15.jpg")
                    .category(3)
                    .intro("전 세대를 사로잡은 우리 시대의 감동 소설 '불편한 편의점'의 두 번째 이야기")
                    .build();

            books[16] = Book.builder()
                    .name("불편한 편의점")
                    .imgPath("/img/book-cover/16.jpg")
                    .category(3)
                    .intro("누적 판매 50만부 돌파! 2022년 상반기 가장 많이 팔린 책")
                    .build();

            books[17] = Book.builder()
                    .name("나 혼자만 알고 싶은 실전 심리학")
                    .imgPath("/img/book-cover/17.jpg")
                    .category(8)
                    .intro("'인생은 심리의 힘겨루기!' 수맣은 일과 관계에서 나를 지키는 법")
                    .build();

            books[18] = Book.builder()
                    .name("조금 서툴더라도 네 인생을 응원해")
                    .imgPath("/img/book-cover/18.jpg")
                    .category(8)
                    .intro("다른 사람과 발맞추려 애쓰지 말고 차분하게 당신의 인생을 걸어가라")
                    .build();

            books[19] = Book.builder()
                    .name("매일을 헤엄치는 법")
                    .imgPath("/img/book-cover/19.jpg")
                    .category(2)
                    .intro("80여만 구독자 미술 크리에티터의 첫 번째 그림 에세이")
                    .build();

            books[20] = Book.builder()
                    .name("유배도 예술을 막을 수 없어")
                    .imgPath("/img/book-cover/20.jpg")
                    .category(10)
                    .intro("허균부터 정약용까지 고난 속에서 피어난 조선 7인방")
                    .build();

            books[21] = Book.builder()
                    .name("데이터는 어떻게 인생의 무기가 되는가")
                    .imgPath("/img/book-cover/21.jpg")
                    .category(1)
                    .intro("당신의 모든 선택에서 진짜 원하는 것을 얻는 법")
                    .build();

            books[22] = Book.builder()
                    .name("초대받지 않은 형제들")
                    .imgPath("/img/book-cover/22.jpg")
                    .category(3)
                    .intro("우리보다 훨씬 발달된 문명을 가진 '초대받지 않은 형제들'과 현대인이 만나면 어떻게 될까?!")
                    .build();

            books[23] = Book.builder()
                    .name("인간 본성 불패의 법칙")
                    .imgPath("/img/book-cover/23.jpg")
                    .category(1)
                    .intro("타인의 마음을 열기 위해 나는 이 책을 열었다!")
                    .build();

            books[24] = Book.builder()
                    .name("부자의 그릇")
                    .imgPath("/img/book-cover/24.jpg")
                    .category(7)
                    .intro("당신이 다룰 수 있는 돈의 크기는 얼마입니까?")
                    .build();

            books[25] = Book.builder()
                    .name("사람을 얻는 지혜")
                    .imgPath("/img/book-cover/25.jpg")
                    .category(4)
                    .intro("누구에게도 적이 되지 않는 가장 현실적 조언")
                    .build();

            books[26] = Book.builder()
                    .name("리마케팅하라!")
                    .imgPath("/img/book-cover/26.jpg")
                    .category(15)
                    .build();

            books[27] = Book.builder()
                    .name("해방 전후사의 재인식")
                    .imgPath("/img/book-cover/27.jpg")
                    .category(10)
                    .build();

            books[28] = Book.builder()
                    .name("우리가 초복을 내일이라 부를 때")
                    .imgPath("/img/book-cover/28.jpg")
                    .category(15)
                    .intro("우리는 이 보이지 않는 줄기들과 맞닿아 있다")
                    .build();

            books[29] = Book.builder()
                    .name("검당i")
                    .imgPath("/img/book-cover/29.jpg")
                    .category(20)
                    .intro("고졸검정고시 한국사 교과서")
                    .build();

            books[30] = Book.builder()
                    .name("과학이 필요한 시간")
                    .imgPath("/img/book-cover/30.jpg")
                    .category(13)
                    .intro("소년 같은 궤도가 아껴둔 과자 같은 과학들")
                    .build();

            books[31] = Book.builder()
                    .name("카메라 끄고 씁니다")
                    .imgPath("/img/book-cover/31.jpg")
                    .category(4)
                    .intro("제 식구들 이야기를 계속 우려먹고 우리는 계속 곱씹어야 합니다")
                    .build();

            books[32] = Book.builder()
                    .name("트렌드 코리아 2023")
                    .imgPath("/img/book-cover/32.jpg")
                    .category(9)
                    .intro("더 높은 도약을 준비하는 검은 토끼의 해")
                    .build();

            books[33] = Book.builder()
                    .name("하얼빈")
                    .imgPath("/img/book-cover/33.jpg")
                    .category(3)
                    .intro("'칼의 노래'를 넘어서는 김훈의 새로운 대표작")
                    .author("김훈")
                    .build();

            books[34] = Book.builder()
                    .name("자연탐사 GOGO 카카오 프렌즈")
                    .imgPath("/img/book-cover/34.jpg")
                    .category(20)
                    .intro("아마존 열대우림 자연탐사")
                    .build();

            books[35] = Book.builder()
                    .name("지구를 구한다는 거짓말")
                    .imgPath("/img/book-cover/35.jpg")
                    .category(13)
                    .intro("아마존 선정 2021년 최고의 과학책")
                    .build();

            books[36] = Book.builder()
                    .name("베니스의 상인")
                    .imgPath("/img/book-cover/36.jpg")
                    .category(3)
                    .build();

            books[37] = Book.builder()
                    .name("아버지의 해방일지")
                    .imgPath("/img/book-cover/37.jpg")
                    .category(3)
                    .build();

            books[38] = Book.builder()
                    .name("대면 비대면 외면")
                    .imgPath("/img/book-cover/38.jpg")
                    .category(9)
                    .intro("뉴노멀 시대, 우리는 어떻게 연결되는가")
                    .build();

            books[39] = Book.builder()
                    .name("화폐의 추락")
                    .imgPath("/img/book-cover/39.jpg")
                    .category(7)
                    .intro("우리가 놓친 인플레이션의 시그널")
                    .build();

            books[40] = Book.builder()
                    .name("금자랑 놀자!")
                    .imgPath("/img/book-cover/40.jpg")
                    .category(20)
                    .intro("중학 국어2-2 자습서")
                    .build();

            books[41] = Book.builder()
                    .name("자이언트 임팩트")
                    .imgPath("/img/book-cover/41.jpg")
                    .category(7)
                    .intro("충돌하는 세계는 어떻게 부의 질서를 재편하는가!")
                    .build();

            books[42] = Book.builder()
                    .name("안일한 하루")
                    .imgPath("/img/book-cover/42.jpg")
                    .category(2)
                    .intro("이번 생에 미련은 없지만 태어났으니 재밌게 살아보려는 매일의 고군분투!")
                    .build();

            books[43] = Book.builder()
                    .name("BEAMS AT HOME")
                    .imgPath("/img/book-cover/43.jpg")
                    .category(1)
                    .intro("일본을 대표하는 멋쟁이 단체 빔즈스태프 87인의 한결같은 라이프 스타일")
                    .build();

            books[44] = Book.builder()
                    .name("스즈메의 문단속")
                    .imgPath("/img/book-cover/44.jpg")
                    .category(3)
                    .intro("신카이 마코트 감독이 각본 소설 '스즈메의 문단속'")
                    .build();

            books[45] = Book.builder()
                    .name("Number BLOCKS")
                    .author("cbeebies bbc")
                    .imgPath("/img/book-cover/45.jpg")
                    .category(18)
                    .intro("OFFICIAL ANNUAL 2023")
                    .build();

            books[46] = Book.builder()
                    .name("IT STARTS WITH US")
                    .author("colleen hoover")
                    .imgPath("/img/book-cover/46.jpg")
                    .category(14)
                    .intro("#1 NEW YORK TIMES BESTSELLING AUTHOR OF IT ENDS WITH US")
                    .build();

            books[47] = Book.builder()
                    .name("BEATS of a LITTLE LAND")
                    .author("Juhea Kim")
                    .imgPath("/img/book-cover/47.jpg")
                    .category(18)
                    .intro("As the Korean independence movement gathers pace," +
                            " two children meet on the streets of Seoul.\n" +
                            "Fate will bind them through decades of love and war.\n" +
                            "They just don’t know it yet.")
                    .build();

            books[48] = Book.builder()
                    .name("LIFE AS WE KNEW IT")
                    .author("Susan Beth Pfeffer")
                    .imgPath("/img/book-cover/48.jpg")
                    .category(18)
                    .intro(" With the threat of famine looming, " +
                            "ten-year-old Jade is sold by her desperate family " +
                            "to Miss Silver's courtesan school " +
                            "in the bustling city of Pyongyang.")
                    .build();

            books[49] = Book.builder()
                    .name("위국일기")
                    .author("야마시타 토모코")
                    .imgPath("/img/book-cover/49.jpg")
                    .category(1)
                    .build();

            books[50] = Book.builder()
                    .name("악녀가 새언니가 되었다")
                    .imgPath("/img/book-cover/50.jpg")
                    .category(11)
                    .intro("원작 속 악녀가 내 시누이라면?\n" +
                            "그것도……\n" +
                            "멸문을 불러일으키는 어마어마한 악당이라고?")
                    .build();

            books[51] = Book.builder()
                    .name("참아봐 어디 한번")
                    .imgPath("/img/book-cover/51.jpg")
                    .category(11)
                    .intro("190cm가 넘는 신장에\n" +
                            "햇빛을 덮어쓴 듯한 금발, 푸른 눈동자\n" +
                            "해링턴 호텔의 후계로 모두가 바라는 남자, 에단 해링턴")
                    .build();

            books[52] = Book.builder()
                    .name("얼굴천재로 태어난 신입사원")
                    .imgPath("/img/book-cover/52.jpg")
                    .category(11)
                    .intro("딱 하루라도 좋으니 미남으로 살아보고 싶었던 신입사원 도진훈.\n" +
                            "출장을 가는 도중, 교통사고를 당하게 되는데......")
                    .build();

            books[53] = Book.builder()
                    .name("조국의 법고전 산책")
                    .imgPath("/img/book-cover/53.jpg")
                    .category(4)
                    .intro("쓰러지지 않고 세상 속을 걸어가는 사유와 성찰")
                    .build();

            books[54] = Book.builder()
                    .name("나의 문화유산답사기")
                    .imgPath("/img/book-cover/54.jpg")
                    .category(14)
                    .intro("내 고향 서울 이야기 서울편 3 사대문 안동네")
                    .build();

            books[55] = Book.builder()
                    .name("한계선을 넘다")
                    .imgPath("/img/book-cover/55.jpg")
                    .category(15)
                    .intro("'눈물을 마시는 새' 게임, 영상화를 위한 아트북")
                    .build();

            books[56] = Book.builder()
                    .name("데일 카네기 인간관계론")
                    .imgPath("/img/book-cover/56.jpg")
                    .category(15)
                    .intro("전 세계 6천만 부 판매된 최고의 인간관계 바이블\n"+
                             "워렌 버핏의 인생을 바꾼 사람을 다루는 핵심 원리")
                    .build();

            books[57] = Book.builder()
                    .name("THE ONE THING")
                    .imgPath("/img/book-cover/57.jpg")
                    .category(1)
                    .intro("복잡한 세상을 탈출하는 탈출순위 일")
                    .build();

            books[58] = Book.builder()
                    .name("RICH DAD")
                    .imgPath("/img/book-cover/58.jpg")
                    .category(7)
                    .intro("세계 금융 변화에 맞춘 NEW 코멘트\n"+
                            "토론과 실천을 위한 10가지 스터디 세션 수록")
                    .build();

            books[59] = Book.builder()
                    .name("시민의 불복종")
                    .author("뮌러 데이빗 소로우")
                    .imgPath("/img/book-cover/59.jpg")
                    .category(7)
                    .build();

            books[60] = Book.builder()
                    .name("단순한 열정")
                    .imgPath("/img/book-cover/60.jpg")
                    .category(2)
                    .intro("사적인 기억의 근원과 소외, 집단적 억압을 용기와 일상적 예리함을 통해 탐구한 작가")
                    .build();

            books[61] = Book.builder()
                    .name("클루지")
                    .imgPath("/img/book-cover/61.jpg")
                    .category(8)
                    .intro("더 나은 의사결정을 원한다면 반드시 이 책을 읽어라!")
                    .build();

            books[62] = Book.builder()
                    .name("모순")
                    .imgPath("/img/book-cover/62.jpg")
                    .category(3)
                    .intro("작가 양귀자가 1998년 펴낸 네 번째 장편소설로, 책이 나온 지 한 달 만에 무서운 속도로 베스트셀러 1위에 진입,\n" +
                            "출판계를 놀라게 하고 그해 최고의 베스트셀러로 자리 잡으면서 ‘양귀자 소설의 힘’을 다시 한 번 유감없이 보여준 소설이다.")
                    .build();

            books[63] = Book.builder()
                    .name("지중해 요리")
                    .imgPath("/img/book-cover/63.jpg")
                    .category(6)
                    .intro("출간 즉시 베스트자리에 오른 뒤 오랜 시간 동안 꾸준한 사랑을 받아온 《지중해 요리》가 출간 10주년을 맞아 새롭게 태어났다!\n" +
                            "이번 개정판은 초판 출간 이후 약 10년 만에 나오는 만큼, 그동안 바뀐 우리나라 시장과 독자들의 니즈를 반영하여 요리 목록을 새롭게 구성했다.")
                    .build();

            books[64] = Book.builder()
                    .name("만화로 배우는 요리의 역사")
                    .imgPath("/img/book-cover/64.jpg")
                    .category(6)
                    .intro("재미있는 만화에 깊이를 더한 요리의 세계사")
                    .build();

            books[65] = Book.builder()
                    .name("그럴수록 요리")
                    .imgPath("/img/book-cover/65.jpg")
                    .category(6)
                    .intro("뮤지션이자 칼럼니스트, 생활 요리인 네코자와 에미가 선사하는 마음을 채워주는 행복 레시피")
                    .author("네코자와 에미")
                    .build();

            books[66] = Book.builder()
                    .name("나의 반려견 반려묘 요리책")
                    .imgPath("/img/book-cover/66.jpg")
                    .category(6)
                    .intro("내 소중한 가족, 반려동물의 식생활, 건강, 행복, 무병장수 등을 고민하는 반려인들을 위해 만든 책이다. \n" +
                            "저자는 오랜 반려인이자 자타 공인 미식가 커플로, 한 분은 펫푸드 영양학 전문가(김초롱)이고 다른 한 분은 미슐렝 레스토랑 출신 셰프(박규원)다.")
                    .author("김초롱, 박규원")
                    .build();

            books[67] = Book.builder()
                    .name("세상이 밤이라면!")
                    .imgPath("/img/book-cover/search-category-comic.jpg")
                    .category(11)
                    .intro("가엾게도, 최강의 흡혈귀는 인간계에 떨어지고 말았다. 지위, 돈, 그리고 옷……. \n" +
                            "모든 것을 잃은 알몸의 그녀는, ‘밤에도 밝은 거리’ 도쿄에서, 절체절명의 궁지에 몰리는데...")
                    .author("무치마로")
                    .build();

            books[68] = Book.builder()
                    .name("원피스")
                    .imgPath("/img/book-cover/68.jpg")
                    .category(11)
                    .intro("해적왕이라고 불리웠던 'G 로저'가 남긴 보물 중의 보물 <원피스>를 둘러싸고 펼쳐지는 대해적 시대. \n" +
                            "악마의 열매를 먹어버린 소년 루피는 미래의 해적왕을 꿈꾸며 동지를 모으기 위해 위대한 항해를 시작한다.")
                    .author("오다 에이치로")
                    .build();

            books[69] = Book.builder()
                    .name("귀멸의 칼날")
                    .imgPath("/img/book-cover/69.jpg")
                    .category(11)
                    .intro("다이쇼 시대, 숯을 파는 마음씨 착한 소년 카마도 탄지로는 어느날 도깨비에게 가족을 몰살당한다. \n" +
                            "유일하게 살아남은 누이동생 카마도 네즈코 마저도 혈귀로 변하고 만다. \n" +
                            "절망적인 현실에 큰 타격을 입은 카마도 탄지로였지만, 카마도 네즈코을 인간으로 돌려놓기 위해, \n" +
                            "가족을 죽인 혈귀를 심판하기 위해, 귀살대의 길을 가기로 결의한다.")
                    .author("고토게 코요하루")
                    .build();

            books[70] = Book.builder()
                    .name("창발의 시대")
                    .imgPath("/img/book-cover/70.jpg")
                    .category(17)
                    .intro("우리가 사는 현재를 이해하려면 과거를 알아야 한다. 그래서 우리는 역사를 공부하고 그 속에서 오늘날 우리에게 도움이 되는 교훈을 얻는다. 역사학 박사이자 인기 있는 역사 팟캐스트 시리즈 ‘역사의 조류(Tides of History)’를 제작하는 패트릭 와이먼은 이 책에서 서양과 세계 역사 모두에 결정적 전환점이 된 시기의 이야기를 들려준다.")
                    .author("패트릭 와이먼")
                    .build();

            books[71] = Book.builder()
                    .name("21세기 평화와 종교를 말한다")
                    .imgPath("/img/book-cover/71.jpg")
                    .category(17)
                    .intro("종교계 두 거장이 나눈 허심탄회한 대화이지만, 종교를 정면으로 다루는 책이 아니다. 기독교인의 정신과 불교의 정신을 바탕으로 하되, 그보다 한 차원 높은 ‘인간의 조건’에 대해 말한다.")
                    .author("하비 콕스, 이케다 다이사쿠")
                    .build();

            books[72] = Book.builder()
                    .name("세 종교 이야기")
                    .imgPath("/img/book-cover/72.jpg")
                    .category(17)
                    .intro("베스트셀러 <유대인 이야기>로 호평을 받은 저자 홍익희는 세 종교의 시작을 연 인물인 아브라함의 뿌리가 되는 고대 수메르 문명부터 기독교를 국교로 제정한 로마제국, 기독교와 이슬람교 간에 치러진 십자군전쟁과 일방적인 유대교 박해가 행해진 중세 암흑기를 거쳐 홀로코스트와 팔레스타인 분쟁까지 전 방위적으로 세계사를 아우르며 이 책을 통해 세 종교 간 대립을 끝내고 평화공존의 관계를 모색해야 한다고 주장한다.")
                    .author("홍익희")
                    .build();

            books[73] = Book.builder()
                    .name("가장 쉬운 일본어")
                    .imgPath("/img/book-cover/73.jpg")
                    .category(18)
                    .intro("일본에 여행 갔을 때 벌어질 수 있는 상황을 현장감 있게 담았다. 상황별로 필요한 문장과 단어를 알려주고, 간단한 문장 패턴을 활용해 다양하게 표현할 수 있도록 했다.")
                    .build();

            books[74] = Book.builder()
                    .name("일본어 무작정 따라하기")
                    .imgPath("/img/book-cover/74.jpg")
                    .category(18)
                    .intro("18년 동안 일본어 베스트셀러&스테디셀러로 38만 독자들에게 전폭적인 사랑을 받아온 <일본어 무작정 따라하기>가 <일본어 무작정 따라하기 심화편>과 합쳐져 이번에 완전체의 형태를 선보인다. ")
                    .build();

            books[75] = Book.builder()
                    .name("센스 있는 영어 표현")
                    .imgPath("/img/book-cover/75.jpg")
                    .category(18)
                    .intro("유튜브 16만 구독자의 에디 쌤이 원어민의 폼나고 트렌디한 영어 말센스를 얻는 비법을 알려준다. 이 책엔 누구나 바로 말할 수 있는 쉽고 간단한 영어 표현 200개와 원어민만 아는 뉘앙스 설명과 회화 꿀팁이 수록되어 있다. 이 표현을 모두 익힌 후에는 원어민이 인정하는 센스 있는 영어를 구사하게 될 것이다.")
                    .build();

            books[76] = Book.builder()
                    .name("물리의 정석: 특수 상대성 이론과 고전 장론 편")
                    .imgPath("/img/book-cover/76.jpg")
                    .category(13)
                    .intro("인류가 시간과 공간을 통합적으로 이해할 수 있게 만들어 주었다고 하는, 그 이름은 누구나 알지만 정확하게 이해하는 이는 드물었던 특수 상대성 이론. 이 책은 특수 상대성 이론에 대해 이처럼 오랜 목마름을 품고 있던 독자를 위해, 레너드 서스킨드(Leonard Susskind)의 인기 유튜브 강의 「최소한의 이론(Theoretical Minimum)」 중 특수 상대성 이론과 고전 장론 관련 강의 10개를 모은 책이다.")
                    .build();

            books[77] = Book.builder()
                    .name("초끈이론의 진실")
                    .imgPath("/img/book-cover/77.jpg")
                    .category(13)
                    .intro("지은이는 물리학계에서 초끈이론이 가지는 위상과 그 실체를 명확히 하기 위해 먼저 표준모형 완성에까지 이르는 100년간의 입자물리학 발전사를 꼼꼼하게 설명한다. 그가 특히 강조하는 것은 학문 발전은 이론과 실험이 서로를 검증하며 보완할 때 이루어진다는 점과, 수학이 물리학 발전에 끼친 중요성이다. 물리계에서 수학적 대칭이 가지는 의미와 그 중요성을 현란한 비유 대신 엄밀한 정의로 우직하게 설명한다.")
                    .build();

            books[78] = Book.builder()
                    .name("해수어 대백과")
                    .imgPath("/img/book-cover/78.jfif")
                    .category(16)
                    .build();

            books[79] = Book.builder()
                    .name("처음 시작하는 열대어 기르기")
                    .imgPath("/img/book-cover/79.jpg")
                    .category(16)
                    .intro("열대어를 처음 기르는 사람이 꼭 알아야 하는 기본지식을 사진과 일러스트로 쉽게 가르쳐준다. 또한 물고기를 기르고 싶지만 혹시 실수할까봐 주저하는 사람들에게도 열대어 전문점의 베테랑이 Q&A를 통해 완벽한 대답을 들려준다.")
                    .build();

            books[80] = Book.builder()
                    .name("초미니 수족관 보틀리움")
                    .imgPath("/img/book-cover/80.jpg")
                    .category(16)
                    .intro("작은 병 속에 나만의 작은 수족관 ‘보틀리움’을 만드는 방법을 소개한다. 책상 위나 침대 머리맡, 혹은 식탁 한 편에 놓아두고 감상할 수 있는 보틀리움은, 작은 병이나 화병 속에 꾸밀 수 있어 부담 없는 작은 아쿠아리움이다. 또한 보틀리움은 적은 비용으로 누구나 쉽게 만들 수 있다는 것도 큰 장점이다. 만드는 데서 그치지 않고 집을 장식하거나 수중 생물을 키우는 즐거움도 맛볼 수 있다. 주변에서 흔히 구할 수 있는 수초나 생물로 꾸밀 수 있다는 점도 보틀리움의 큰 매력이다.")
                    .build();

            books[81] = Book.builder()
                    .name("예술, 인간을 말하다")
                    .imgPath("/img/book-cover/81.jpg")
                    .category(15)
                    .intro("예술과 역사를 아우르는 깊이 있는 시각으로 찬사를 받은 <예술, 역사를 만들다>와 예술과 공간의 관계를 탐색한 <예술, 도시를 만나다>를 쓴 전원경 작가의 저서이다. 삶을 고양하는 예술 시리즈로서 환희와 고통, 희망과 무기력이 교차하는 복잡한 우리의 현실에서 예술은 저만치 떨어져 있는 고고한 무엇이 아니냐는 의문에 새로운 답이 되어 준다.")
                    .build();

            books[82] = Book.builder()
                    .name("Art and Fear : 예술가여, 무엇이 두려운가!")
                    .imgPath("/img/book-cover/82.jpg")
                    .category(15)
                    .intro("예술가이자 오랜 친구인 두 사람이 함께 쓴 책으로, 창작 활동을 하면서 직접 경험하고 느낀 것들을 7년에 걸친 대화와 논의를 거쳐 만들어냈다. 이들은 예술을 특출한 소수의 천재들이나 하는, 별난 것으로 정의하지 않는다. 지은이들 역시 우리와 같이 현실에 발을 딛고 사는 평범한 예술가들이이기에, 예술가들의 고뇌와 어려움을 잘 알고 있다.")
                    .build();

            books[83] = Book.builder()
                    .name("건강과 다이어트를 동시에 잡는 채소·과일식")
                    .imgPath("/img/book-cover/83.jpg")
                    .category(5)
                    .intro("한약사가 알려주는 채소·과일식 해독법. 다이어트 보좌관이자 피토테라피스트 한약사 조승우가 《건강과 다이어트를 동시에 잡는 채소·과일식》을 세상에 내놓는다.")
                    .build();

            books[84] = Book.builder()
                    .name("마이크로바이옴, 건강과 노화의 비밀")
                    .imgPath("/img/book-cover/84.jpg")
                    .category(5)
                    .intro("현대 의학에서 최첨단연구 분야인 마이크로바이옴은 건강과 노화에서도 단연 주목받고 있다. 우리 몸속에는 우리의 세포보다 더 많은 수의 미생물이 우리 몸을 서식처로 자리 잡고 있다. 건강한 노화에 필요한 것은 미생물과 건강한 공생 네트워크를 형성하는 것이다. 이 책은 미생물과 함께 건강하게 나이 들기 위한 구체적인 안내서이고, 장수를 위한 미래에 펼쳐질 미생물 세상에 대한 혁신적인 가이드북이다.\n")
                    .build();

            books[85] = Book.builder()
                    .name("50 이후, 건강을 결정하는 7가지 습관")
                    .imgPath("/img/book-cover/85.jpg")
                    .category(5)
                    .intro("예전 같지 않게 머리가 잘 안 돌아가고, 몸이 부어 있고, 늘 몸이 좋지 않다고 느낀다. 이러면 우리는 바로 ‘나이가 들었다는 신호’라 생각한다. 하지만 이런 증상들은 나이 들면 당연히 찾아오는 것이 결코 아니다. 다만 늦기 전에 ‘조치를 취하고 생활방식을 바꾸라는 신호’일 뿐이다. 《50 이후, 건강을 지키는 7가지 습관》은 직설적인 안내서이자 최적의 몸 상태를 위한 청사진이다.")
                    .build();

            books[86] = Book.builder()
                    .name("자바 ORM 표준 JPA 프로그래밍")
                    .imgPath("/img/book-cover/86.jpg")
                    .category(12)
                    .intro("에이콘 오픈 소스 프로그래밍 시리즈. 자바 ORM 표준 JPA는 SQL 작성 없이 객체를 데이터베이스에 직접 저장할 수 있게 도와주고, 객체와 관계형 데이터베이스의 차이도 중간에서 해결해준다. 이 책은 JPA 기초 이론과 핵심 원리, 그리고 실무에 필요한 성능 최적화 방법까지 JPA에 대한 모든 것을 다룬다. 또한, 스프링 프레임워크와 JPA를 함께 사용하는 방법을 설명하고, 스프링 데이터 JPA, QueryDSL 같은 혁신적인 오픈 소스를 활용해서 자바 웹 애플리케이션을 효과적으로 개발하는 방법을 다룬다.")
                    .author("김영한")
                    .build();

            books[87] = Book.builder()
                    .name("토비의 스프링 3.1 Vol. 1")
                    .imgPath("/img/book-cover/87.jpg")
                    .category(12)
                    .intro("대한민국 전자정부 표준 프레임워크 스프링을 설명하는 No. 1 베스트셀러! 단순한 예제를 스프링 3.0과 스프링 3.1의 기술을 적용하며 발전시켜 나가는 과정을 통해 스프링의 핵심 프로그래밍 모델인 IoC/DI, PSA, AOP의 원리와 이에 적용된 다양한 디자인 패턴, 프로그래밍 기법을 이해할 수 있도록 도와준다. 이어지는 [Vol. 2 스프링의 기술과 선택]에서 상세히 소개하는 스프링 3.0과 스프링 3.1의 방대한 기술을 쉽게 이해하고 효과적으로 응용하는 데 필요한 기반 지식을 쌓도록 도와준다.")
                    .author("이일민")
                    .build();

            books[88] = Book.builder()
                    .name("객체지향의 사실과 오해")
                    .imgPath("/img/book-cover/88.jpg")
                    .category(12)
                    .intro("위키북스 IT Leaders 시리즈 23권. 객체지향이란 무엇인가? 이 책은 이 질문에 대한 답을 찾기 위해 노력하고 있는 모든 개발자를 위한 책이다. 이 책의 목적은 특정한 기술이나 언어를 설명하는 데 있지 않다. 대신 객체지향적으로 세상을 바라본다는 것이 무엇을 의미하는지를 설명하는 데 있다. 이를 위해 많은 사람들이 가지고 있는 객체지향에 관한 잘못된 편견과 선입견의 벽을 하나씩 무너트려가면서 객체지향이 추구하는 가치를 전달한다.")
                    .author("조영호")
                    .build();

            books[89] = Book.builder()
                    .name("일본온천여행")
                    .imgPath("/img/book-cover/89.jpg")
                    .category(14)
                    .intro("휴식과 힐링의 대명사 일본 온천 여행의 모든 것을 알려주는 가이드북. 2023~2024 최신판에는 코로나 펜데믹 이후 새롭게 정비된 일본의 대표 온천 여행지 39곳을 소개했다. ")
                    .build();

            books[90] = Book.builder()
                    .name("소소낭만, 일본 소도시 여행")
                    .imgPath("/img/book-cover/90.jpg")
                    .category(14)
                    .intro("일본 소도시 여행을 위한 최초의 가이드북이다. 팬데믹 이후 변화된 정보들을 업그레이드 하여 개정판에 담았다. 소박한 멋과 맛, 낭만이 있는 일본 소도시로 친절하게 안내한다. ")
                    .build();

            books[91] = Book.builder()
                    .name("세계 철학 필독서 50")
                    .imgPath("/img/book-cover/91.jpg")
                    .category(19)
                    .intro("고대의 플라톤부터 현대의 마이클 샌델까지 세계 철학사의 지형을 바꾼 50권의 명저를 한 권에 담은 책이 출간됐다. 2500년 철학사에서 50명의 철학자를 엄선해, 그들의 핵심 사상과 대표 저작의 정수를 한 권당 10분이면 읽을 수 있도록 쉽게 정리한 책이다.")
                    .build();

            books[92] = Book.builder()
                    .name("현대 철학의 최전선")
                    .imgPath("/img/book-cover/92.jpg")
                    .category(19)
                    .intro("우리 시대 철학에서 가장 뜨거운 다섯 가지 주제를 둘러싸고 벌어지는 철학자들의 논의를 담은 사유의 지도와 같은 책이다. 공정한 사회의 근거를 어떻게 만들 것인가(정의론), 어떻게 타자와 서로 인정하고 승인할 것인가(승인론), 과학의 언어로 환원 불가능한 인간의 법칙은 있는가(자연주의), 인공지능은 의식을 가질 수 있는가(마음 철학), 그리고 인간 중심주의의 끝을 향해 가고 있는 지금, 상대주의적 세계관과 가치관을 넘어서는 철학적 사고는 가능한가(새로운 실재론)까지. 다섯 개의 영역에서 서로 다른 배경과 입장을 지닌 철학자들의 생각을 연결하고 교차시키면서 각각의 영역에 어떤 물음이 있고 어떻게 논의되고 있는지, 철학이 어떤 실천인가를 이야기한다.")
                    .build();

            for (Book book : books) {
                em.persist(book);
            }

            Member member = Member.builder()
                    .name("테스터2")
                    .nickname("테스터2")
                    .phone("01012345678")
                    .birth("901020")
                    .sex("1")
                    .pw(passwordEncoder.encode("1234"))
                    .address(new Address("서울 당산동","145가","K013"))
                    .role(MemberRole.USER)
                    .build();

            em.persist(member);

            Review[] reviews = new Review[10];

            reviews[0] = Review.builder()
                    .member(member)
                    .book(books[24])
                    .rating(3)
                    .tag("#재밌어요")
                    .content("그 사람을 통하면 뭐든지 해결될 것 같은 사람이 있는가?\n" +
                            "그는 어떻게 그런 인간관계를 만들게 유지할 수 있었을까?\n" +
                            "가만히 생각해 보니 책에서 말한 3가지 유형을 적절히 잘 사용한 것 같다.")
                    .build();

            reviews[1] = Review.builder()
                    .member(member)
                    .book(books[14])
                    .rating(5)
                    .tag("#공감돼요")
                    .content("우리가 지금 알고있는 민주주의의 본거지, 자유의 상징, 세계 최강대국 미국이 아닌 지금의 미합중국이 만들어지기까지의 우여곡절을 간략하고 쉽게 보여주는 책이다. 다뤄야 할 지역, 내용이 방대하다보니 상세히 설명하지 않는 부분이 많지만 추가적으로 더 찾아볼 수 있을 정도의 정보는 충분하다. 약간 위키피디아 읽는 느낌을 지우기 힘들긴 했지만 포함된 컬러 사진, 그림들 보는 재미도 있었다. 미국사를 다룰때 중요한 부분이 지리적 위치 정보를 지도를 통해 보여주며 각 지역들이 어떻게 연관이 있는지 맞춰져가는 내용도 유익했다. 막상 도시명은 알아도 지도에서 찾으라고 하면 어려운 곳이 많은데 지도로 보니 또 남달랐다.")
                    .build();

            reviews[2] = Review.builder()
                    .member(member)
                    .book(books[33])
                    .rating(4)
                    .tag("#최고에요")
                    .content("사실 내용들이 무릎을 탁 칠만큼 대단하다기보다는 그냥 잘 읽히고, 스스로를 돌아보게 하는 내용이에요.")
                    .build();

            reviews[3] = Review.builder()
                    .member(member)
                    .book(books[55])
                    .rating(5)
                    .tag("#재밌어요")
                    .content("소설에 이은 책이라 읽어보니 정말 잘 내용이 풀어져 있어서 읽기도 좋은 책이라 추천합니다!")
                    .build();

            reviews[4] = Review.builder()
                    .member(member)
                    .book(books[45])
                    .rating(3)
                    .tag("#쉬웠어요")
                    .content("재밌습니다. 그런데 초등학교 고학년이 되니 다른 시리즈에 비해 좀 시시해하는거 같습니다.")
                    .build();

            reviews[5] = Review.builder()
                    .member(member)
                    .book(books[54])
                    .rating(4)
                    .tag("#좋아해요")
                    .content("책을 읽다보면 공감되는 것도 많고 이해하기 쉬워서 좋은 책입니다^^")
                    .build();

            reviews[6] = Review.builder()
                    .member(member)
                    .book(books[67])
                    .rating(5)
                    .tag("#최고에요")
                    .content("이 책은 인간의 심리학에 대한 다양한 이론과 내용을 예를 들어서\n" +
                            "잘 설명해주는 책입니다.\n" +
                            "사회나 직장, 이성간의 심리를 잘 이용하면 성공적인 관계를\n" +
                            "\n" +
                            "이룰수 있으며 발전적인 모습을 만들 수 있습니다.\n" +
                            "이 책으로 심리학에 대해 많이 알게되는 유익한 책입니다.")
                    .build();

            reviews[7] = Review.builder()
                    .member(member)
                    .book(books[76])
                    .rating(4)
                    .tag("#추천해요")
                    .content("맘에 들어요 추천합니다")
                    .build();

            reviews[8] = Review.builder()
                    .member(member)
                    .book(books[80])
                    .rating(5)
                    .tag("#추천해요")
                    .content("쉽게 구성되어 있어서 잘 활용할 것같아요! 적극 추천드려요.")
                    .build();

            reviews[9] = Review.builder()
                    .member(member)
                    .book(books[21])
                    .rating(5)
                    .tag("#좋아해요")
                    .content("이 책은 삼국지의 조조의 청학과 심리학을 현대에서도 배울수 있는 책으로\n" +
                            "조조의 지략과 때에 따른 판단력은 삼국지 전체의 인물 중 최고라고\n" +
                            "생각됩니다.\n" +
                            "\n" +
                            "인간 심리와 관계 처세에 관심이 많으신 분은 꼭 이 책을 읽어보시길\n" +
                            "\n" +
                            "추천합니다.")
                    .build();

            for (Review review : reviews) {
                em.persist(review);
            }

            UploadFile[][] files = new UploadFile[10][5];

            files[0][0] = UploadFile.builder()
                    .review(reviews[0])
                    .storeFileName("4b7ed0ca-e14b-44aa-ae99-cb5185f35e55-20221217-231325.jpeg")
                    .build();

            files[0][1] = UploadFile.builder()
                    .review(reviews[0])
                    .storeFileName("5bc32630-d64c-4062-92a8-2ef44448f856-20221217-230446.jpg")
                    .build();

            files[1][0] = UploadFile.builder()
                    .review(reviews[1])
                    .storeFileName("15b2d2c5-f890-490b-b4bf-270b747f3bd6-20221217-231332.jpg")
                    .build();

            files[3][0] = UploadFile.builder()
                    .review(reviews[3])
                    .storeFileName("18d23924-df40-405e-a4cd-0ff13a04743b-20221217-231325.jpeg")
                    .build();

            files[5][0] = UploadFile.builder()
                    .review(reviews[5])
                    .storeFileName("430df81a-02e2-481e-862c-201621abbff7-20221217-231822.jpg")
                    .build();

            files[5][1] = UploadFile.builder()
                    .review(reviews[5])
                    .storeFileName("998c18fc-2dfc-4215-8eea-16dd3847f586-20221217-231332.jpg")
                    .build();

            files[5][2] = UploadFile.builder()
                    .review(reviews[5])
                    .storeFileName("29580a3f-d52c-41c0-9310-1cc5632de0e7-20221217-230446.jpg")
                    .build();

            files[5][3] = UploadFile.builder()
                    .review(reviews[5])
                    .storeFileName("90481a1d-d592-4d29-b37c-aaacc876cc7b-20221217-234136.jpg")
                    .build();

            files[5][4] = UploadFile.builder()
                    .review(reviews[5])
                    .storeFileName("b8a399ac-141c-4e30-8712-53e94ecc2d1a-20221217-231332.jpg")
                    .build();

            files[8][0] = UploadFile.builder()
                    .review(reviews[8])
                    .storeFileName("bcb76ec0-fc00-4a4c-a174-dce5e2998501-20221217-231332.jpg")
                    .build();

            files[8][1] = UploadFile.builder()
                    .review(reviews[8])
                    .storeFileName("cc8319b1-75c6-42b9-8cf1-368254532f53-20221217-231131.jpeg")
                    .build();

            files[8][2] = UploadFile.builder()
                    .review(reviews[8])
                    .storeFileName("e19823ce-8fce-4063-aa6e-63540e4464cb-20221217-231325.jpeg")
                    .build();

            files[8][3] = UploadFile.builder()
                    .review(reviews[8])
                    .storeFileName("f486e6f2-757b-4ace-bad4-a948ab7a2e25-20221217-230427.jpg")
                    .build();

            files[8][4] = UploadFile.builder()
                    .review(reviews[8])
                    .storeFileName("fdd317e1-4934-427f-a4c6-0501003bc128-20221217-231332.jpg")
                    .build();

            for (UploadFile[] file : files) {
                for (UploadFile innerFile : file) {
                    if(innerFile != null){
                        em.persist(innerFile);
                    }
                }
            }
        }
    }
}