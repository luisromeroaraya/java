import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { Product } from "../../types/product";
import { Subscription } from "rxjs";

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  // variables
  private _products: Product[] = [
    {
      id: 1,
      title: "Car",
      description: "As new",
      image: "https://media-cldnry.s-nbcnews.com/image/upload/newscms/2019_42/3052526/191015-used-car-mn-0920.jpg",
      price: 1500,
      quantity: 3
    },
    {
      id: 2,
      title: "Pair of shoes",
      description: "Very comfortable",
      image: "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAoHCBYWFRgWFRYZGRgaHBgaGhgaGhoaHBoZGBwaGhkcGRocIS4lHB4rHxgZJjgmKy8xNTU1GiQ7QDs0Py40NTEBDAwMEA8QGhISHjQhISExNDE0NDExNDQ0NDE0MTE0NDQ0NDQ0MTQ0MTQ0MTE0NDQxNDQ0NDQ0NDQxNDQ0ND89P//AABEIAMIBAwMBIgACEQEDEQH/xAAbAAAABwEAAAAAAAAAAAAAAAAAAQIDBAUGB//EAEYQAAIBAgMEBgYGCgIBAwUAAAECEQADBBIhBTFBUQYTImFxkTJCUoGhsQcUYsHR8CMzU3KSorLC0uEVgpMX0/EWQ3O08v/EABgBAQEBAQEAAAAAAAAAAAAAAAABAgME/8QAIhEBAQEBAAICAgIDAAAAAAAAAAERAhIhMUEDUTJxImGB/9oADAMBAAIRAxEAPwCqRSRGaKTcQ85qOs99O5D315G03DsOrKxuYGfERUYvrQw7ETyOlC6NaLCrjaCKtujTSlxe/wCYP+AqmB0irPou4zup4hT5GP761A5cqOTUm9y5aVmcfjbisSjOMrif1WXL3W2bM3PtROmgq88+Rbi9Z+yV5xwHCeNSsI3YP73+NZD/AJ64oOdQR2YL2jbEGPWtt38j91WWC6RpBUpMkapcB1jhbcK5Gn5kVrwsTyjpWA7WFvDgbLjzRhWF2WT1Kx7Gh+1ljU1e7L6W4RbT23dkZkdR1iOkmGU8wIOh1qh2Un6NVD22IAHYuW314RlYk0s9JL7SUDkqQRl9YEHNPce7lUw3Jb/qp851+FIS2zkSrKYiQGgkQAW4QOJ1pK2ypJaOA3+8+6TUa1IA1rWdGzFsHvun+VfwrHXcXbQS7oo03sBvEj4a1YbN6YYVLZUuzsBd0t23fRgIJIERodZ4VeZdS3055ivTf94/OmHIA1pzFqS7sFYA53AKnRSSQWAnKABrO6odwSQDy385I1HdvreOWH7aneB/upKIN531Aa8Sd8AEeVWqbKxJTP1F4qdzBLhBB3EQKvMY6l+kcJRyBRRBjX76H/HXcq9hiSZIjUcd2+s35ak0WadafRRFQ1uGANDLcRw/IpYxDTwjMB+NQ8T13lSXFNvdMiI1MDvjeaNLhMnlpH40MJNG2pXnmX+oU4YPdSdCyAe0Px+6pavM9tAho6atmnDXJ1Iam8GNCeZ+VDEPCk09hlhV8KB2TQo5oqCsSadYn2qbNhxvUjxBFAKaoUqmd9Lc0gLB10pbxzqBsmrHo9pcY/Yb4Qx/pquNWPR1c2JRYkHOD3Aown41VTsZ6beJ+dc72+Dnuz7QPm0/fXRdpCHbSN2nLQaGK590knrLgjgh8fRP+q6fj+U6+FVbMbmInTQkSDvGnCpAub8wRiRElQDx1lYk67zPCoyinwldnM4mJyjs5kgggI7BZ4kq2aTHfR9cOc8NbaGQd+ZgQxPLf7pqM4ospoJ3WrzTlJF0ae0QDvIjTdp7yTX1iRlBOulstqogL221B4/fuqERSSxoL6zj4sgIxzKCVIS3babbZ2M6kjJeuR+6YA1zQDipjslgIgPcd4Ans6FRlkk7vvlvAXYzTuGRzvIhWAYRyKO8+FLwdtOsVLjAJ1iJccHcmcK7Bv3ZM0C7BLKWFtkUFj1iI2VCT7Xo5RyMeI31YIzOO0FzKqk5Z1nMc44QQNeTI24tFbjbD3UxtizaUphSttU6tSIUoM7hhpIJbu7BBHPI7RS3axV5FC5LbeiFMAuqdYoyzlCuzGI0yRTNLPS66J7OAZbrqGYn9GDwO7NHOd3hPHSx250wuK7WsOxVV0e4plnb1ob1VBkCN8TMVXPtDJbZlIWFCoZEBj2VgiQYAJH7tUNjZ924BkRgvtN2FMAyczQDAB0EnTiaxbZ6jU5XrY1sSjM5DX7YDi5ADXLcgOrkbyoYMDyUjlS+vykEEaQZPAxPHSdJ5bp765MOltRnYOw0JEhQYkAesx1XeJg+iIzCFicUWIA9EcN0+InuGk7xOp1q+O3abnqBeyu5KjszA0j0ezJ113bzv7t1N3LYjQd/vpWFjtCIhjpv3gNp5mnSQazZ7c/eoaW928RPjJp1VA3TT2UUnIKhtNHWhaQ508T8jSzbFHh17a9wY/IffUvwvPytkNOio808Grk6mcSZgcyBUkMJj8xUZUJeSNBPnUgCqFTQopoVBrv+Q+2P5qH10H1l/Puqlz0OsreC+baH2186bfFKeKGO9TVIblJNymRdWxNvjbQ+4Uy7207SIqvwfivOPlFVbvTLvWbzF0vEXixJJ1JJNYvpQO23CRbM89SPnWqd6zXSxdUPMRHH0gR9/lXTj5Z6+FEltuBHlTkMKVh150MSQBoa7uZlmNLQmK2/Rv6P7l1VuYktbRhK2lH6VxvkyISeRE+FdB2J0OwCiPq1t98l2a4dNDJYkAg6QN1RfGuGPaMSRTMiumdLOjFuxehUIRpKQWMd2vf86xu09gMqdYnaQb+anTeOWu+r4pqpwYGdQdzSh/7gpP8ANScW0tJ9dVY6esRDyOecP5UwwINTccMy5+8PpuHW5g4+yBcttA3dvnvgnYTpLiraZExDqukCQY4aEiQe/fUHDXQHGY6MSGYsZ7QIZi2uvaJ4zxmodjDs7qias7KiiYlmIVRPiRWxu9FbKXhg2vO2IygsAFyBiubKqle0QusZwdDqDVgRZ2hdRE7bAEldNRnXLnkqw4hxqZPvmlYjbB1VZkhFZm1JyKqkfaBKknMTNVj5kd0b01dlfQEZ0LBgpABKkdqSNRmioKNrEd3hVSrMXcxkmeA5ATMADcNToKS605gMBcfS1be43EIjPHjlGnvpvHYW5aaLyPbPBXRlJ8JGu/hRVv0X2auIvNaa4UbJnXslpytlYHUR6S1qT0E5Ygd02z/lWN6L7R6rEIw7IJKT+/AX+YIPfXS02pc9r4CuHcvl6a5ksU3/ANBPwvJ/C34023QS96ty2f4h/bWjXatzmPIUpdqv9nyrP+S+EZZugeI4Nb/ib/Git9BsSpnsHh6X4itcu1n5L8fxoztVj6q/Gp/l9r4xlX6K4hd6p/Gv3mkt0dvj1F/8lv8AyrVvtGYJRSRxNJu4tWBDICDvE/LlU8V9MuvRzEESEkdzIf7qNej1/wDZt8D8jWps48KAAkAbgDFSF2ksRk0mdCN/Pdvp4oxo2Df/AGb/AMJoVsP+Qt+y/wD5XH91HTxHPuvoG9UDrKUtwQZmeG6O+a0JnW0k3KiB6Vmop+dJ4UljTeekM9QKY1nelOrJ/wBvh/8A1V678/zwrL7bxGe4QDogy+LHVvuFa4ntnq+kO3a0rdfRh0fW7dbE3VDJaYJbRvRa9oQzDiFBU+LDlWEQmDBruH0fWlTB4VRxRrhOurXHJPjAPy5692I0d2yWjLqczg9tkLlQQTmQEqA3DduO+Kcw+zVtt1rN247TaKvoqHJAAkEpm1mJMQKY2klxlY4Z0t3uDOgdWj1X9aO8HTkd1cx2902x6rdwuJS2jMpRsqOrZW0JRs5UgiRIHOt/j/Fe/it3vJkdV2RjrWNw63FXMj5hDDUZWZTPI6fGnMHsCxbzAICGJMMARrvEborlPRTpm2GQWktBlJLZQ5WDlUcUeZI7vOa61sbaLX7YuNaa3mAIV98HmIBHDQgVfycXi39MT24T9JPRgYHE9gfoboL2x7EEB0n7JKkdzAcJrMYW4CpVogabtyNoxJjcri20fvd9dw+mTBh8Bn42rttge5z1ZHh2wfcK4KGytO/fpzBEEHuIJHvrkHMPfZHVlgPbdWE6gMjSJjeJFbS70uwz3ExL2rvXpJChxlLsqoWk6gEKDG6SxiSax+Ntz2gZ0XMZkkEdhv4YVuTDvFRFcigsxjHuXHd4z3HLzlJh2bMAo3wT2eOh41otg7HOJfMgGUBCZJAWQCASdTEZSRvKtVBhdj3HVGORM+qBnKsw9pVCkxxk+O6tv0X2A8OlxyouCLgQlSAdSM3MmTwGp4VvnNSytJgdoIlhbWHuoc2eCIlyjFWKoPUBHpQRxqg6d4lkw2V2BZ3SF4KwlmI5aCPBh41qbPRqzhVUWUYI8h2kTI1h3PajfGukHXnyDpntj6ziDkI6u3KJHEes3fmIEdwWnWfS/WGNn3hnQzoroxO/0XVoHMwprrVtwQCNQdQe41x3BqWUIFHifnHGuj9DXb6vkYljbd0BO8gQR5Zo91cu561ea0Qo6IUK5NlA0YNEKEUAJo50oUdUBWpQJpINOCoE0KXQoOZDGJ7Y86dtYhWIVWBJIAAIkk6AAcTUpUtn1V8hVp0etWhfQlVBGaDGoYiBHnSWVrFNtNGtPaRjlDkhm9mCAQCdx361o9m4W1AXIA/HMczfzSasdrbIS6CjqCrSeRB5qeDH7+8znpvYMBbyG/hh6N1BF22OTrxUfDmN1XEaQYBDvVTPNR+FV+N2cgnsqD7x8BTmExCXUz2LmdNJykyvcynVT41A2njHtozxxhdDLsdwHH367qmDO7cxYtsERYIUs8zoPVjxg/CsgvfqTJJ7zqfjUzat93eC4Yt22MQGJ3R9gAacIjuqELb8h7jXbnnHO3TgrsHQHFrcwVkBtUzWHHIq+dAeYKED/sa44xPEGr3oh0iOEvEsC1lwFuou+B6Lp9pSSe8EjlFSOz4S1kJRLqAkEhcillAjcAwhAW3R63MzWH2rsDE4/EyoyYe2MiXbky4BJd0Te+ZyTOgIy61tsI6XFS7acOj657ZjrCglFmRkMgyhy6zJiQ0y9fKWw7wSd+9ANCx3gkwAdwkxMCt8fkvN37bvM6zHPujGybmD2glu8isHS6LLkdhmAVgVaDkfKjAiJEneNT07D4l4gpqNc2Zcp1JhY13QJKjfxiq7GXXllVEZkNtlBJaQ7lM0AdiAH7UmORpk4gWluXXulUjMxuFctsHWNBqwJKgKTPZG8auu71dp4ZPdVn0t48LgOrJE3biKo4xbPWMfAFFH/YVw24K0HTLpIcbfzqCtpAUtId+UmWZvtMQCeQCjhWe31linsNd3KdSJAExnU6vbnnPaXk27UimL9qJAIIIlWHFTuP8ArgZHCiOhmYO+RpBHEHhU2RcWSRqd86JcMyCI0V4nTQNyEzBrRtC1d6u/bv2LV3Itu6l+RkC+tZIIBBB3fZFVe1dv3OtIw164LahVzBihdhJZiFiBJyjuUHjWeAIkEEEaEEQQRvBHA1Y7GwTXneCFS2jXHcgtlReSgjMxJgCRPOtGrZNuYlrF2ycRcdXQrlds3ZkazEggBlOoEd1UeG2M7h2UFgglyo9Abpbuq/wWzbc9Zdf9EIyoxyyzbi5B1kD0RvjjFW1npH9XtdTgFVGOru6dpxO5ANw1gk69w4XNSs9gsMEED31sejCRYndLuf5iv9tV+M2MwsjEJDKUDuE3CRLEAbgCTpwA8autl7Mi0klwcikgOwEnU7jHGsfk+Dn5WS0qmU2b9t//ACP+NK/477b+Odta4up0Uqmjs48Lj/xGjXZzftH/AIu7w/M0DkUcUhMA0j9I8RukTPOY08KP6g37R/Nf8aA4o5pP/Ht+0fzXd/DRDZ7/ALR/5P8AGmBeahTX/HN+1fzT/Gjpg5t1L938R/CpeALo6sd069rgdKLPRNerEabyzfDoUdiJEB1ABAEEEE8dPhUzDsWUZmDMNCw0kjSR48uFYPAbYKGG1Xz+H59+6tJhtoI6yjgnkx04acjp7/CK6fKI+1Oi6M/W2Waxd9u12ZnXtoNCJ3xBPGaz/SHZ2Pyq93LiEQatbEMJ3lk0kkQJUeXHaJjtIcR38/Aa03cuo2hie8ajXu1HGrLiWOPXCS5JB3CZ372OvmKC91XHShYxlyOSHnrlHHjVQyV0c6NXPKgzrxWjV+dE5qifsbbt7CsWw9xkn0k9JH/fRuyT37+RFbLBfSoyrFzDITpJt3HtAxr6BDAedc7IFDKKDouN+lIkHJhhOsNdus48SiKs66xP3Vitu9IcRiyDfcsq6oijJbTh2UGkxxMnvqvyCiyVU0wWoSafyUfVeHnRUVhS7N0qZiQQQVMwynerRrGg7wQCIIFP9T3jzFEcOfyRTA5cQNGUyToCYl49VgN1wc/WAB3nWw6N7WGGulmQOjqyXbZJXMjSDB4MJJHfVZbUidJB0ZTuI7+8bwd4qRkV95ObXUwH0iMxMK/j2WPfoKC32/ta1dCW7FtrdtWzsbjZ7ly52gMzbgqhmgDn3ABjAYR3DtnREtgG47kqi5jlQSoLFiZgKJ0NVl3BMP8AU7t0kEAgeIG8VY7MxKtafDXyUR3S6LgQuFdFKgOqmWQqx3agmdd1UaHobtLFDEdShR7RPbuMxKQQO0rQJeBoIWfWHGuo4tMKlnMxFtRufXUncoX1uWUbq4zidrDDMqYZ84A1fIyKCSQVRTBIjiQNTu51+GxV/E3SLt5gFR3ZmBbKiCTlUbt/Aaa6Gs3/AGf06RiNuFWUW0N5WJAe2VK6c5IIPd7t8CpN98Q7ZLRW04Em3etsHI1MowYq27lWG6J7ftYR2dyzgkEHdlUH0gonUz47qm9IfpHOIdOpsZBbeVct225CBooJ3rJnTUVJzGrTu0em93D3WtPZIKxrcgMQdzAJ2cpGo3+JqXs/pqlxgpOQngQPgaldNrNrHYNMQulxFzpA7TKdXSOJgbuDL3meXphQ3rGfBT8AZNZ65hLY7IMWxiHmd0GnUuuOJ+dYHo/tl7RVLhDp6rjlu1kSO4nuB36dDs3VZQYJESCBP531yvNjcsp3D4jNod/h91IxWMa06pcULn0RxJVz7PNXjXKeG4mDD1jCGcyhuBg92/jVBtvFtjr1rCYY58j57l0eiGUFdG4ogZpbiSAO/fM1m+l19f7v5W/ChVziNjPmOQnLOmg9/wAZoqvjTXGzSGmngtEVrlG6iPTa3WUypj88RxqW6U29vT/VajKZgekjpo4le78D9xFXWH23h7mmYKTwnLJ15+NZF8NTLYU1r0ntL6VqPrOYEEOiEf8AUsD91UxrSJsQ3sKHtgm7bZlKjUujEsMo4sCSI4xGpIrLuCN/5P3VufDNhxhNIyRSVel5pqoQyUkinQaS1UNzRzR0ljQDNRzSS1DNQWWzdltdR7rOluykB7jzGZvRVVGrNuMcjR7X2W+HZA5VluILlt0nK6HcRPu8xqQaVsvbCpZuYe9a62w7C5GYqyOoAzKw4wANe/nTe3dsHENbAQJbtItu2mYtlReJY7ydPIeJCGHqw2Xgrl9mRAvZUu7uwRERd7O7aKPnVSGq12HtUWutRkD276i3cWcpIBzKyt6rKfEGe6rofxuFuYfIXCm3cUtbdGzJcAgNlJAkiRvHEeNJ+tKd6zPHiTzJobX2oj2bGGso6WrJdgXYMztcMnVQAqjWAN+YnlVSLlTRbuiNxI+MeG8k+VHYTIyuj5HUyrTlIMcPMgg8yDpVUL1L66gucRad0dRbtAtBe4qZHOU5iN4UAmJKqCd0661mHssNRvBEEFZDAyNPEcqTbvmdD5VIs4p59JzvIJJPdOu/d8KC4TaryubCqSuY5UN9EJnMT1avA1MmImeFVTbOdme46MgZmaFQ72lyEU7kE+kdABvJEFb3z7CHxtp+E1Iwl53/AEaWs7EEFU6zNkzKwAytMB9SIjtndpDDQNxQuQESSsQwYCJ0d+Ig+pA041vejHSXDJhmN1iz2lDZFAzspOWBrBhp1kaa+Od2b0Xxl4xkuIvrG4WtqOZOfUjTgDurebB6AWEVmvlrrsI1kIu6CoPpaACTpA3UvMWWoPU4zaAKqBhcLqHMks44y2hYdwyrvkmtjsDYdnCpksqRMZnPpORz5DfpoBw3zVjbsjSeG5eCxugc++nS3Aan5eNQKihUC/tG2jFWeCN4146/fQoOFxShbp8WTQ6uvLrqjstIIFSGApGWtIayigVqQRSctNFjsLEZA+YHICjkgA5ShzT/AAqfIVotrdHMNie2yQx1F1DkY/vRox/eBrFriCgdeFxGRvBhvHeDr586uuj3STqgtvEMFB0S6Z6u4BuzE+g8b5j3Vqb9IrsX9HZn9HfUjlcQg+9kn+mon/prjYlOpYc0ut/cgrplq5ZciSVndBBUz361NTZ2U9hyJ5/iIrfPVSyOP3fo/wAev/2c3hdt/ewpA6CY47rKjxu29PJjXaFwBO9p95p1MJA3+6P91rb+kyOLp9HONO82V8bjn+lDT6fRliI7V60PDrD/AGiuuXyo3nyA++aYa/AEJIG8tOo92k1m9WL4xy9Poxu8cRb91tz82FP2/oxPrYn3Laj4lz8q3WJ6QWbfpvaXxdZ8pqsfpraP6tnuHlatO/xVfvp5dGRn1+jS1xv3T4Kg+YNOH6NbPtYk+BT/ANurV9vYx/Qw98A8bjpbHkXn4VDvYraB3hF/evOT5KkfGs29fsyIL/RzaHHE/wAn/t0w30e2/axH8n+FPu+L4m173uf40kPix6ltvC6w+BSp5dftcn6Mf+n9v2r/AIyn+FJHQBP2l0e5P8KljaGIX0sLcPejq3l2gfhSv/qlV/WLibf7yPHmCam9GcobdAE4Xn96KflFIboCeGIjxtz8nFXuF6V4Z92KUfvlk/qAq3sYzOJS4j94yN8RV8uoePLEW+gzhtMSo7+rI+Ger7ZfQKyqxcvuxP7NEQ+8tnq9RzOqK3hpU227eyFHu+ZFWd0vMVadE8Ih/VM5HtuzeYWFPlVjsu4lklbdtLYO8LbCTroZAE08m1bYfq3uWy7aqocFo5BRJLb9KcVCxGRGaNNVZez35wONanlfael7s8gjNM8ddy+HKnH2go0EsfsiRvIGo3SQQPA1A2dhLvV5bhCGWjIZgMTvgDUCBP8A81Hv7ew2Hzahm5JDMT9ojsr7zNbRZszAZnIXXdMeAB4CfeY91V21ekaICtvV93ML+9393nWU2t0lu3zAARBuCklve34RVcjRWOuv0siwe9mJZiSTqSeNCo3W91Cuamjs9fb/AJf90h8AntHyFWhtik9SO+piqNtnp7R8vumkHArGjHy/3WguIrEdhRAjQRO/U99JSwJ0Hwous8cGOZ+FJOFX7XwrS/V15UPqi8VqYmsjewqni3kKhhCk5SxVvSRgrIw+0rKQfHeOEVt3wiezTP8AxyH1a1KjH4fF2kaVS/aG8ixcGVvG3dVh5GtxZ+kDDR2g6/vJP9E1EfY6H1RTD7GT2RWp0mNBhum+Efdc13mUcd3Fe+pQ6YYQb7yCd05huieHePOsZsbZCriYIEFWHvEMPd2avtq7JTIpyjR43Ce0pJEcNUPvNdJd51LPat2pibVxmZdp3wrEnIiquWeAZLckcNdfGq4YLAn9ZcxN8/ba8QfgtWybNXkKeXBqOArF6XFfh7+FT9VgRPtMqT/ExZqefbuIOiWkQciS3yAqemE3nLoIkxpruovqwncKz5GKa9jMS29lHgv4zUS+l1t7t7mZf6SK0hsim2wq1NVj7mEfm/8A5Ln+VEFuruLe9mb+o1rmwo5Ch9SU8BQZEbSxKcQfEfhUux0muLo9okc1M/Ax860R2cnIeVJbZSRuFBRXNp4W7+ssrP27cnzANRLuy8E5zIiqfs3HXyGorSHYyclpC7JXktamJVCuzLI3Ym6vcLjR8EoX9j4dlg3bjn7RY/2ir9tlpyFOLs5fs1r/AKe0jA7bsWgAlglgBrCLMCJMeHLjUh+mF4+giJv5ue7XQTu4c+WsIYBe6lJgV5inkmI+J2hevAC65fmO0qnT2FaPSg+FM27KgiUHhqNJOm/lHlVoMGtA4JedLVxFtInsDxk8vGnkROKjdpv389/5mn0wi86d+qLzqYqF1I/IFCp/1ZOdFUxNM9Z4edH1v5mmQH+z8aSQ/dWVSFuUtXB/O/31CyvzFH2+Y8qCUbvdQF6mBm5jy/3SSG5jyoJDPSVvx+TUdiw9YD3D76Ze6w9b4CgntepFzEQKrzfc8R5Clph2f0nUeOnyFAjZ2IP1m2ddWyj/ALKVGnHU7q0+1P1DmNxRtIjUgf3N5nxObw+BXOrZwCrAgyd4MiPKtbj0Bw9wyYI4cJZWHz+Xea68fxsS32zK4nupwX54VGS2I9I0WQe0a5KnpjXAyjd3afEa02HPKmFUe0fOj6tfaPmaZgeLnu+NF2u6msie0fOjCJzPnQOqD3Uok/kUxlTmfOlpZQ7vnQCWpUHjQbCoJJgR3/KKZZLfMHzqaHzIHD/4jX40QOg3eFRitvkKSRb5CqJRbwpWfw86hfo+Qo8ych5U0Sw/ePMUl3juqMrJ3eVBricvhTQ897vHnSRiB7Q86YNxOXwos6ez8KaJQxP2h50oYo+2POoguJ7PwoG4vBfhTRL+s/bHn/ujqH1q8j5ChTTCvrj8x/Cv4UZvufW+A/Clrap1LVQMZ35mgQ3M1L6uj6umCFDczQKNzNTOro+rqiAUPM0XU1YdXQ6umJrP9ILbrhrr22ZWRQ2YcAGUH4E1eWrK5EMGCqEySfSVSTqeZPdupO0MOWsYhB61i9pzItsyz7wKk9GAz4PDOwAZraCZkBU7IbXWeyJEHfvpfhUV7MHdHdr+M1oNpPOGGurlJ93aPxHzqvvpBI5HfzqdjF/QWxpvP5+Nb4uS/wBJfpnWsUh7FWZtTApL2CJ7qwqtSxS/q9TEs051FBXnD0a2I8iOPER99T+o/OlF1P5mpgr1w/gPOjbDjuqf1HePOliwOY8/9UwVZw9F9Xq0+r94+P4UTWRz/PGmCrFilCzFWX1fu90H7vdTZtjlVEMWqPqRUsoOVAJ4fH7qCKLPeaH1epZXuHxowe4eOv40EPqaT1FTiKTFBE+r0sYfu+6pdsQZ8vHnRZaCJ1VCpEHlQoDVKdVaSHHfShcHfQKihFF1o5Gh1vcaA4oiKHW9xojc7jQHFGFpPWHlQDtyoJeDUu2STBVxHDVW4cifnVH0KXLg8O+doZGlcxygh2Q6Tr6Px7qtsNinQysDUc4McxNVOwCyC7ZWMlu8wSVBKq6pdiTwzXDVIunuTHdpwqTiD+jTwb51CVnJ1jfwVR91ScWzQgHI8jvJ4Hwqz4qVGIonGlF1bczRZGHrHzrKggpeWo/VHmfOnBab2j5mgcIoglD6ueZ86BwvfQ0eSN4pIWh9WofVBQBxFIzjmPMUo4UUX1YUxNHI9pf4hTbMOY9xmljDijNgVcNIVlPrKPExRZ19oUpcOKUcP4Uw02txfaHk34Ug3V5/Bvwp7qaMWBTDTBurz+B/CiF8ciakmxRixTFRTij7J+FKF8cVPw31KFmldRUwROsHst5/6oVM6ihTDTAoUKFADSjRUKA6MUdCgTRrR0KoAqv2T+sxX/5k/wD17FHQoLSn8XuTwP8AUaFCtz+NSmKI0KFYDQ31IFChVChQNChQE1EtChQBqI0VCgUKI0VCgKnBQoVQhqAoUKBYozQoVCBVpYtLlHZHkOdChSqIoOQ8qFChUH//2Q==",
      price: 50,
      quantity: 20
    },
    {
      id: 3,
      title: "Red wine",
      description: "Merlot",
      image: "https://images.wine.co.za/GetWineImage.ashx?ImageSize=large&IMAGEID=268493",
      price: 20,
      quantity: 10
    },
    {
      id: 4,
      title: "Piano",
      description: "Really good",
      image: "https://www.omega.be/images/ashx/yamaha-clp-735-r-clavinova-piano-bin1.jpeg?s_id=YAMAD6E9B9&imgfield=s_imagebin1&imgwidth=1200&imgheight=1200",
      price: 600,
      quantity: 4
    },
    {
      id: 5,
      title: "Frigobar",
      description: "Cool",
      image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFVgFalDQdBou2iXt3yS3wpv9kpW-b9SkzwQx0PVUCtlUhKFihVjuEgPO8mdONTLMUslM&usqp=CAU",
      price: 100,
      quantity: 5
    },
    {
      id: 6,
      title: "DVD Aladdin",
      description: "A Disney classic",
      image: "https://i.ebayimg.com/thumbs/images/g/~ikAAOSwovFi7t6y/s-l300.jpg",
      price: 2,
      quantity: 1
    }
  ];
  product?: Product;
  private routeSubscription?: Subscription;

  // constructor
  constructor(private route: ActivatedRoute) {
    this.routeSubscription = this.route.paramMap.subscribe(params => {
      const id = params.get("id");
      if (id != null)
        this.product = this.Products.find(e => e.id == parseInt(id));
    });
  }

  // getters
  get Products(): Product[] {
    return this._products;
  }

// methods
  ngOnInit(): void {
  }

  ngOnDestroy() {
    this.routeSubscription?.unsubscribe()
  }

  buy(value: Product) {
    if (value.quantity != 0)
      value.quantity = value.quantity - 1;
  }
}
