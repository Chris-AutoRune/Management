package io.autorune.updater.analyzer.classes.implementations.io

import io.autorune.updater.analyzer.classes.ClassAnalyzer
import io.autorune.updater.analyzer.classes.annotations.CorrectFieldCount
import io.autorune.updater.analyzer.classes.annotations.CorrectMethodCount
import io.autorune.updater.analyzer.classes.annotations.DependsOn
import org.objectweb.asm.tree.ClassNode

@CorrectFieldCount(0)
@CorrectMethodCount(0)
@DependsOn(AbstractSocket::class)
class BufferedNetSocket : ClassAnalyzer() {

    override fun findClassNode(): ClassNode? {
        for (classNode in classPool) {

            if (classNode.superName != getClassAnalyserName(AbstractSocket::class))
                continue

            val match = classNode.fields.count { !isMemberStatic(it.access) } == 3

            if (match)
                return classNode

        }
        return null
    }

    override fun getFields() {

    }

}