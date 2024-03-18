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
    writeln('========== Zadanie 1a ==========');
    writeln('Losowe liczby:');
    setlength(rnd_arr, num);
    size := num;
    for i := 0 to num-1 do
    begin
        r := min + Random(max-min);
        writeln(i, ': ', r);
        rnd_arr[i] := r;
    end;
end;

procedure Zadanie1b;
var
    i, j, tmp: Integer;
begin
    writeln('========== Zadanie 1b ==========');
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
    writeln('Posortowane liczby:');
    for i := 1 to size do
        writeln(i, ': ', rnd_arr[i]);
end;


begin
    minVal := 11;
    maxVal := 15;
    numVal := 10;
    Zadanie1a(minVal, maxVal, numVal);
    Zadanie1b;
end.