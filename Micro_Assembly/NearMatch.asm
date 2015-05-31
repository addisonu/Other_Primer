TITLE NearMatch								      (NearMatch.asm)
; Creation Date : 05/23/15
; Revisions : 3
; Date : 05/25/15
; Program Description :
    ; Write a procedure named CountNearMatches that receives poiners to two arrays of signed doubleswords,  parameter that indicates the length of the two arrays and a parameter that indicates the maximum allowed difference between any two correspnding elements.
    ; For each element x_i in the first array, if the difference between it and the matching y_i in the second array is less thn or equal to diff increment a count.
    ; At the end, return a count of the number of nearly matching array elements in EAX. Write a test program that calls CountNearMatches and passes the pointers to two different pairs of arrays.
    ; Use the INVOKE statement to call your procedure and pass stack parameters. Create a PROTO declaration for CountNearMatches. Save and restore any registers (other than EAX) changed by your procedure.

INCLUDE Irvine32.inc

CountNearMatches PROTO, ptrArray1:PTR SDWORD, ptrArray2:PTR SDWORD, szArray:DWORD, diff:DWORD

    .data
    array1a SDWORD 1,2,3,4,5,6,7,8
    array1b SDWORD 5,7,8,7,5,75,43,4
    array2a SDWORD 5,44,7,65,8,7,23,4
    array2b SDWORD 8,2,5,46,55,65,35,4
    cnt DWORD ?,0
    dif1 DWORD 11
    dif2 DWORD 0

    .code
    main PROC		
            INVOKE CountNearMatches, ADDR array1a, ADDR array1b, LENGTHOF array1a, dif1
            call WriteInt
            call Crlf
            INVOKE CountNearMatches, ADDR array2a, ADDR array2b, LENGTHOF array2a, dif2
            call WriteInt
            call Crlf
            exit
            main ENDP

    CountNearMatches PROC USES edx ebx edi esi ecx, ptrArray1:PTR SDWORD, ptrArray2:PTR SDWORD, szArray:DWORD, diff:DWORD
            mov esi,ptrArray1
            mov edi,ptrArray2
            mov ecx,szArray
; Loop
    L1:
; compare sets
    mov ebx,0
    mov ebx,[esi]
    mov edx,0
    mov edx,[edi]
    .IF ebx > edx
            mov eax,ebx
            sub eax,edx
    .ELSE
            mov eax,edx
            sub eax,ebx
    .ENDIF
    .IF (eax <= diff)
            inc cnt
    .ENDIF
    add esi, SIZEOF SDWORD
    add edi, SIZEOF SDWORD
    loop L1
; increment count
    mov eax,0
    mov eax,cnt
    mov cnt,0
    ret
    CountNearMatches ENDP
    END main
