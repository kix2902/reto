#!/usr/bin/env bash

SOLUTION_FOUND=0
SOLUTION_NOTFOUND=1

declare TEST_SOLUTION
declare TEST_ELEMENTS
TEST_SOLUTION[0]=$SOLUTION_NOTFOUND
TEST_ELEMENTS[0]=""
TEST_SOLUTION[1]=$SOLUTION_NOTFOUND
TEST_ELEMENTS[1]="1 2 3"
TEST_SOLUTION[2]=$SOLUTION_NOTFOUND
TEST_ELEMENTS[2]="-5 -3 2 4 7"
TEST_SOLUTION[3]=$SOLUTION_NOTFOUND
TEST_ELEMENTS[3]="-83314 -82838 -80120 -63468 -62478 -59378 -56958 -50061 -34791 -32264 -21928 -14988 23767 24417 26403 26511 36399 78055"
TEST_SOLUTION[4]=$SOLUTION_NOTFOUND
TEST_ELEMENTS[4]="-92953 -91613 -89733 -50673 -16067 -9172 8852 30883 46690 46968 56772 58703 59150 78476 84413 90106 94777 95148"
TEST_SOLUTION[5]=$SOLUTION_NOTFOUND
TEST_ELEMENTS[5]="-94624 -86776 -85833 -80822 -71902 -54562 -38638 -26483 -20207 -1290 12414 12627 19509 30894 32505 46825 50321 69294"
TEST_SOLUTION[6]=$SOLUTION_NOTFOUND
TEST_ELEMENTS[6]="-83964 -81834 -78386 -70497 -69357 -61867 -49127 -47916 -38361 -35772 -29803 -15343 6918 19662 44614 66049 93789 95405"
TEST_SOLUTION[7]=$SOLUTION_NOTFOUND
TEST_ELEMENTS[7]="-68808 -58968 -45958 -36013 -32810 -28726 -13488 3986 26342 29245 30686 47966 58352 68610 74533 77939 80520 87195"
TEST_SOLUTION[8]=$SOLUTION_NOTFOUND
TEST_ELEMENTS[8]="1 2 3 4 5 6 7 8 9 10"

TEST_SOLUTION[9]=$SOLUTION_FOUND
TEST_ELEMENTS[9]="-1 1"
TEST_SOLUTION[10]=$SOLUTION_FOUND
TEST_ELEMENTS[10]="-97364 -71561 -69336 19675 71561 97863"
TEST_SOLUTION[11]=$SOLUTION_FOUND
TEST_ELEMENTS[11]="-53974 -39140 -36561 -23935 -15680 0"
TEST_SOLUTION[12]=$SOLUTION_FOUND
TEST_ELEMENTS[12]="-2 2 3"
TEST_SOLUTION[13]=$SOLUTION_FOUND
TEST_ELEMENTS[13]="0"
TEST_SOLUTION[14]=$SOLUTION_FOUND
TEST_ELEMENTS[14]="-3 1 2"
TEST_SOLUTION[15]=$SOLUTION_FOUND
TEST_ELEMENTS[15]="-9 -8 -7 -6 -5 -4 -3 -2 -2 46"
TEST_SOLUTION[16]=$SOLUTION_FOUND
TEST_ELEMENTS[16]="-45 1 2 3 4 5 6 7 8 9"
TEST_SOLUTION[17]=$SOLUTION_FOUND
TEST_ELEMENTS[17]="-98634 -86888 -48841 -40483 2612 9225 17848 71967 84319 88875"
TEST_SOLUTION[18]=$SOLUTION_FOUND
TEST_ELEMENTS[18]="-97162 -95761 -94672 -87254 -57207 -22163 -20207 -1753 11646 13652 14572 30580 52502 64282 74896 83730 89889 92200"
TEST_SOLUTION[19]=$SOLUTION_FOUND
TEST_ELEMENTS[19]="-93976 -93807 -64604 -59939 -44394 -36454 -34635 -16483 267 3245 8031 10622 44815 46829 61689 65756 69220 70121"
TEST_SOLUTION[20]=$SOLUTION_FOUND
TEST_ELEMENTS[20]="-92474 -61685 -55348 -42019 -35902 -7815 -5579 4490 14778 19399 34202 46624 55800 57719 60260 71511 75665 82754"
TEST_SOLUTION[21]=$SOLUTION_FOUND
TEST_ELEMENTS[21]="-85029 -84549 -82646 -80493 -73373 -57478 -56711 -42456 -38923 -29277 -3685 -3164 26863 29890 37187 46607 69300 84808"
TEST_SOLUTION[22]=$SOLUTION_FOUND
TEST_ELEMENTS[22]="-87565 -71009 -49312 -47554 -27197 905 2839 8657 14622 32217 35567 38470 46885 59236 64704 82944 86902 90487"

TESTS_SIZE=22

for ((i=0;i<=$TESTS_SIZE;i++)); do
    printf "Test %02d -> " $i;
    begin=`date +%s%3N`
    ./reto ${TEST_ELEMENTS[$i]} | grep -q "There is a"
    result=$?
    end=`date +%s%3N`
    elapsed=`bc -l <<< "scale=3;($end - $begin)/1000"`
    if [ $result -eq ${TEST_SOLUTION[$i]} ]; then
        echo -e '\e[32;1m OK \e[m [Elapsed' ${elapsed} 's]'
    else
        echo -e '\e[31;1m KO \e[m => ' ${TEST_ELEMENTS[$i]}
    fi
done
