program Zadanie1;
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


begin
    Zadanie1a;
end.