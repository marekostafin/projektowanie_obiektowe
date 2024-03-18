program Zadanie1;
const
    size = 50;
var
    rnd_arr: array [ 1..50] of Integer;

procedure Zadanie1a;
var
    i: Integer;
    r: Integer;
const
    num = 50;
begin
    Randomize;
    writeln('========== Zadanie 1a ==========');
    writeln('Losowe liczby:');
    for i := 0 to num do
    begin
        r := Random(100);
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
        for j := 0 to size-i do
        begin
            if rnd_arr[j] > rnd_arr[j + 1] then
            begin
                tmp := rnd_arr[j];
                rnd_arr[j] := rnd_arr[j+1];
                rnd_arr[j+1] := tmp;
            end;
        end;
    end;
    writeln('Posortowane liczby:');
    for i := 0 to size-1 do
        writeln(rnd_arr[i]);
end;


begin
    Zadanie1a;
    Zadanie1b;
end.