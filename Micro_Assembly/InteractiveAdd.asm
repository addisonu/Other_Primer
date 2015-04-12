InteractiveAdd                                                            (InteractiveAdd.asm)
; Creation Date : 04/09/15
; Revisions : 0
; Date : 04/09/15
; Program Description :
    ; Simple Addition (1) Write a program that clears the screen, locates the cursor near the middle of the screen, prompts the user for two integers, adds the integers, and displays their sum.
    ; Simple Addition (2) Use the solution program from the preceding exercise as a starting point. Let this new program repeat the same steps three times, using a loop. Clear the screen after each loop iteration

INCLUDE Irvine32.inc

    .data
    COUNT = 3
    prompt BYTE "Enter two integers : ",0

    .code
    main PROC

; Ask the user to input a sequence of signed integers
    mov ecx,COUNT

L1:
    call Clrscr
    mov dh,10
    mov dl,30
    call Gotoxy
    mov edx,OFFSET prompt
    call WriteString
    call Crlf
    call ReadInt
    mov ebx,eax
    call ReadInt
    add eax,ebx
    call Crlf

; Display the integer in decimal
    call WriteInt
    call Crlf
    call Crlf
    call WaitMsg
    Loop L1

    call Clrscr
    exit
main ENDP
END main
