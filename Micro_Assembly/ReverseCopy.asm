
Title Reverse Copy                                                                      (ReverseCopy.asm)

; CREATION DATE : 03/26/15
; REVISIONS : 2
; DATE : 03/28/5
; PROGRAM DESCRIPTION : Copy a string in reverse order. Write a program with a loop and indirect addressing that copies a string from source to target, reversing the character order in the process. Use the following variables : source BYTE "This is the source string", 0 target BYTE SIZEOF source DUP(#)

INCLUDE Irvine32.inc
WriteString PROTO


    .data
    source BYTE "This is the source string",0
    target BYTE SIZEOF source DUP('#')

    .code
    main PROC
        mov esi,0
        mov edi,LENGTHOF source - 2
        mov ecx,SIZEOF source
    L1:
        mov al,source[esi]
        mov target[edi],al
        inc esi
        dec edi
        loop L1
        mov edx, OFFSET target
        call WriteString

        exit
    main ENDP
    END main
