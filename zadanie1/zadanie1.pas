program Zadanie1;
var
    minVal, maxVal, numVal: Integer;
    size: Integer;
    rnd_arr: array of Integer;

procedure Zadanie1a(var min: Integer; max: Integer; num: Integer);
var
    i, r: Integer;
begin
    Randomize;
    setlength(rnd_arr, num);
    size := num;
    for i := 0 to num-1 do
    begin
        r := min + Random(max-min);
        rnd_arr[i] := r;
    end;
end;

procedure Zadanie1b;
var
    i, j, tmp: Integer;
begin

    for i := 0 to size-1 do
    begin
        for j := 0 to size-i-1 do
        begin
            if rnd_arr[j] > rnd_arr[j+1] then
            begin
                tmp := rnd_arr[j];
                rnd_arr[j] := rnd_arr[j+1];
                rnd_arr[j+1] := tmp;
            end;
        end;
    end;
end;

// Testy jednostkowe
function Zadanie1a_Test1():integer;
var
  min, max, num: Integer;
begin
    min := 50;
    max := 100;
    num := 10;
    Zadanie1a(min, max, num);

    if num = high(rnd_arr)-low(rnd_arr)+1 then
    begin
        writeln('[1/5] Zadanie1a_Test1 PASSED');
        Exit(1);
    end;
    writeln('[1/5] Zadanie1a_Test1 FAILED');
    Exit(0);            
end;

function Zadanie1a_Test2():integer;
var
  min, max, num, i: Integer;
begin
    min := 50;
    max := 100;
    num := 10;
    Zadanie1a(min, max, num);

    for i := 0 to num-1 do
    begin
        if (rnd_arr[i] < min) or (rnd_arr[i] > max) then
        begin
            writeln('[2/5] Zadanie1a_Test2 FAILED');
            Exit(0);
        end;
    end;
    writeln('[2/5] Zadanie1a_Test2 PASSED');
    Exit(1);            
end;

function Zadanie1b_Test1():Integer;
var
    i: Integer;
begin
    Zadanie1b;
    for i := 1 to size-1 do
    begin
        if rnd_arr[i-1] > rnd_arr[i] then
        begin
            writeln('[3/5] Zadanie1b_Test1 FAILED');
            Exit(0);
        end;
    end;
    writeln('[3/5] Zadanie1b_Test1 PASSED');
    Exit(1);
end;

function Zadanie1b_Test2():Integer;
var
    i: Integer;
    unsorted_array: array[0..9] of integer = (50,30,91,40,80,60,90,10,71,20);
    sorted_array: array[0..9] of integer = (10,20,30,40,50,60,71,80,90,91);
begin
    size := 10;
    setlength(rnd_arr, size);
    for i := 0 to 9 do
    begin
        rnd_arr[0] := unsorted_array[0];
    end;
        
    Zadanie1b;
    for i := 0 to size-1 do
    begin
        if rnd_arr[i] <> sorted_array[i] then
        begin
            writeln('[4/5] Zadanie1b_Test2 FAILED');
            Exit(0);
        end;
    end;
    writeln('[4/5] Zadanie1b_Test2 PASSED');
    Exit(1);
end;

function Zadanie1b_Test3():Integer;
var
    i: Integer;
    unsorted_array: array[0..9] of integer = (50,30,91,40,80,60,90,10,71,20);
    sorted_array: array[0..9] of integer = (10,20,30,40,50,60,71,80,90,91);
begin
    rnd_arr := unsorted_array;
    Zadanie1b;
    for i := 0 to size-1 do
    begin
        if rnd_arr[i] <> sorted_array[i] then
        begin
            writeln('[5/5] Zadanie1b_Test3 FAILED');
            Exit(0);
        end;
    end;
    writeln('[5/5] Zadanie1b_Test3 PASSED');
    Exit(1);
end;

procedure runTests;
var
    passed: Integer;
begin
    passed := 0;
    passed += Zadanie1a_Test1;
    passed += Zadanie1a_Test2;
    passed += Zadanie1b_Test1;
    passed += Zadanie1b_Test2;
    // passed += Zadanie1b_Test3;

    writeln('==========================');
    writeln(passed, '/5 tests passed');
    writeln('==========================');
end;
//

begin
    runTests;
end.